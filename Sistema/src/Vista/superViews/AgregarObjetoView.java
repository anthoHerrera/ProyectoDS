/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.superViews;

import Builders.DirectorLavadora;
import Builders.LavadoraLMA70200WGAB0Builder;
import Builders.LavadoraLMD75B0Builder;
import Builders.LavadoraWMC1786SXWW3Builder;
import Controlador.ConexionPostgresql;
import Modelo.Lavadora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author gabpa
 */
public class AgregarObjetoView {
	
	private final VBox root;
	private HBox contenedorTitulo, contenedorCombo, contenedorBotones;
	private ComboBox comboBoxito, comboLocales;
	private Button agregar,cerrar;
	private Label titulo;
	private Stage stage;
	private Scene scene;
	
	
	public AgregarObjetoView(){
		root = new VBox(20);
		setupPanes();
		setupButtons();
		setupStage();
	}
	
	private void setupPanes(){
		
		contenedorTitulo = new HBox();
		contenedorCombo = new HBox(20);
		
		contenedorTitulo.setPadding(new Insets(10,10,10,10));
		contenedorCombo.setPadding(new Insets(10,10,10,10));
		
		titulo = new Label("Agrega un Objeto al Inventario");
		titulo.setFont(new Font("Arial",24));
		contenedorTitulo.getChildren().add(titulo);
		
		comboBoxito = new ComboBox();
		comboBoxito.getItems().addAll(
			"Lavadora LMA70200WGAB0",
			"Lavadora LMD75B0",
			"Lavadora WMC1786SXWW3"
		);
		comboBoxito.setValue("Lavadora LMD75B0");
		
		comboLocales = new ComboBox();
		comboLocales.getItems().addAll(
			"bodega1",
			"matriz",
			"surcursal1"
		);
		comboLocales.setValue("matriz");
		
		contenedorCombo.getChildren().addAll(comboLocales, comboBoxito);
		
		root.getChildren().addAll(contenedorTitulo,contenedorCombo);
		
	}
	
	private void setupButtons(){
		contenedorBotones = new HBox(20);
		contenedorBotones.setPadding(new Insets(10,10,10,10));
		
		agregar = new Button("Agregar");
		cerrar = new Button("Cerrar");
		
		agregar.setPrefSize(100, 50);
		cerrar.setPrefSize(100, 50);
		
		contenedorBotones.getChildren().addAll(agregar,cerrar);
		
		agregar.setOnAction(e->{
			try {
				validateSelection();
			} catch (SQLException ex) {
				Logger.getLogger(AgregarObjetoView.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		
		cerrar.setOnAction(e->stage.close());
		
		root.getChildren().add(contenedorBotones);
		
	}
	
	private void setupStage(){
		stage = new Stage();
		scene = new Scene(this.root,450,250);
		stage.setScene(scene);
		stage.setTitle("Agregar Articulo");
		stage.showAndWait();
	}
	
	private void validateSelection() throws SQLException{
		DirectorLavadora director = new DirectorLavadora();
		Lavadora lavadora = null;
		
		String modelo = comboBoxito.getValue().toString();
		switch(modelo){
			
			case "Lavadora LMA70200WGAB0":
				director.setConstructorLavadoras(new LavadoraLMA70200WGAB0Builder() );
				director.construirLavadora();
				lavadora = director.getLavadora();
			case "Lavadora LMD75B0":
				director.setConstructorLavadoras( new LavadoraLMD75B0Builder());
				director.construirLavadora();
				lavadora = director.getLavadora();
			case "Lavadora WMC1786SXWW3":
				director.setConstructorLavadoras(new LavadoraWMC1786SXWW3Builder() );
				director.construirLavadora();
				lavadora = director.getLavadora();
		}
		
		//IMPLEMENT CODE DE INSERCION A LA BASE
		ConexionPostgresql conexion = new ConexionPostgresql();
		String query = "select * " +
					"from inventariostock \n" +
					"join inventario On inventariostock.idinventario = inventario.idinventario\n" +
					"where inventario.idlocal like ?";
		PreparedStatement statements = conexion.getCnx().
			prepareStatement(query);
		statements.setString(1, comboLocales.getValue().toString());
		ResultSet result = statements.executeQuery();
		
		String idArtIngresado = this.getArticuloId(modelo);//SE OBTIENE ID DEL ARTICULO SELECCIONADO
		//EN EL COMBOBOX
		String inv = null;
		
		while(result.next()){
			inv = result.getString("idinventario");
			String idArtTabla = result.getString("idarticulo");
			Integer cantArt = result.getInt("cantidadarticulo");
			
			if(idArtTabla.equals(idArtIngresado)){
				cantArt++;
				PreparedStatement updateStatement = conexion.getCnx().
					prepareStatement("UPDATE inventariostock\n"
								+ "SET cantidadarticulo = ?\n"
							+ "WHERE idarticulo like ? ");
				updateStatement.setInt(1, cantArt);
				updateStatement.setString(2, idArtTabla);
				updateStatement.execute();
				System.out.println("cambio algo xd");
				return;
			}
		}
		//SE PROCEDE A INSERTAR SI ES QUE NO SE ENCONTRO EL ARTICULO EN EL INVENTARIO
		ConexionPostgresql insertCon = new ConexionPostgresql();
		String queryInsert = "INSERT INTO inventariostock (idinventario,idarticulo,cantidadarticulo,isvisible)\n"
				+ "VALUES (?,?,?,?)";
		PreparedStatement pre = insertCon.getCnx().prepareStatement(queryInsert);
		pre.setString(1, inv);
		pre.setString(2, idArtIngresado);
		pre.setInt(3, 1);
		pre.setBoolean(4, true);
		pre.execute();
		
		System.out.println("no cambio nada");
						
	}
	
	private String getArticuloId(String modelo) throws SQLException{

		String id = null;
		ConexionPostgresql conexion = new ConexionPostgresql();
		String query = "Select idarticulo\n" +
					"from articulo \n" +
					"where nombre = ?";
		PreparedStatement statements = conexion.getCnx().
			prepareStatement(query);
		statements.setString(1, modelo);
		ResultSet result = statements.executeQuery();
		result.next();
		id = result.getString("idarticulo");
		return id;
	}
}

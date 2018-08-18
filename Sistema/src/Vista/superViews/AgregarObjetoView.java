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
import Modelo.Lavadora;
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
			"LavadoraLMA70200WGAB0",
			"LavadoraLMD75B0",
			"LavadoraWMC1786SXWW"
		);
		comboBoxito.setValue("LavadoraLMD75B0");
		
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
		
		agregar.setOnAction(e->validateSelection());
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
	
	private void validateSelection(){
		DirectorLavadora director = new DirectorLavadora();
		Lavadora lavadora = null;
		
		String modelo = comboBoxito.getSelectionModel().toString();
		switch(modelo){
			
			case "LavadoraLMA70200WGAB0":
				director.setConstructorLavadoras(new LavadoraLMA70200WGAB0Builder() );
				director.construirLavadora();
				lavadora = director.getLavadora();
			case "LavadoraLMD75B0":
				director.setConstructorLavadoras( new LavadoraLMD75B0Builder());
				director.construirLavadora();
				lavadora = director.getLavadora();
			case "LavadoraWMC1786SXWW3":
				director.setConstructorLavadoras(new LavadoraWMC1786SXWW3Builder() );
				director.construirLavadora();
				lavadora = director.getLavadora();
		}
		
		//IMPLEMENT CODE DE INSERCION A LA BASE
		
	}
	
	
}

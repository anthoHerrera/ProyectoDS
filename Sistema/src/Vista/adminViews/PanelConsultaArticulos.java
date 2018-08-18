/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.adminViews;

import Controlador.ControllerAdmin;
import Modelo.ArticuloLineaBlanca;
import Modelo.Ctes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Anthony777
 */
public final class PanelConsultaArticulos {
    private final VBox root;
    private Label titulo;
    private Button regresar;
    private ControllerAdmin controlador;
    private ObservableList<ArticuloLineaBlanca> articulos;
    private TableView<ArticuloLineaBlanca> tabla;
    private Stage articuloStage;
    private Scene scene;

    public PanelConsultaArticulos() {
        root = new VBox(10);
        setUp();
        setUpButtons();
        setStage();
        
    }
    
    public void setStage() {
        articuloStage = new Stage();
        scene = new Scene(this.getRoot(), Ctes.APP_WIDHT - 200, Ctes.APP_HEIGHT - 250);
        articuloStage.setScene(scene);
        articuloStage.setTitle("Consulta Productos");
        articuloStage.setResizable(false);
        articuloStage.showAndWait();
    }

    public void setUp() {
        
        root.setPadding(new Insets(20, 20, 20, 20));
        controlador = new ControllerAdmin();
        tabla = new TableView<>();
        titulo = new Label("Productos");
        titulo.setFont(new Font("Cambria", 40));

        try {
            articulos = controlador.consultaArticulos();
            if (articulos != null) {
                tabla.setItems(articulos);
                tabla.setEditable(false);
                
                TableColumn nombre = new TableColumn("Nombre");
                nombre.setMinWidth(200);
                nombre.setCellValueFactory(
                        new PropertyValueFactory<>("nombre"));
                
                TableColumn descripcion = new TableColumn("Descripcion");
                descripcion.setMinWidth(200);
                descripcion.setCellValueFactory(
                        new PropertyValueFactory<>("descripcion"));
                
                TableColumn marca = new TableColumn("Marca");
                marca.setMinWidth(200);
                marca.setCellValueFactory(
                        new PropertyValueFactory<>("marca"));
                
                TableColumn precio = new TableColumn("Precio");
                precio.setMinWidth(200);
                precio.setCellValueFactory(
                        new PropertyValueFactory<>("precio"));
                
                TableColumn tamano = new TableColumn("Tamano");
                tamano.setMinWidth(200);
                tamano.setCellValueFactory(
                        new PropertyValueFactory<>("tamano"));
                
                TableColumn potencia = new TableColumn("PotenciaTotal");
                potencia.setMinWidth(200);
                potencia.setCellValueFactory(
                        new PropertyValueFactory<>("potenciaTotal"));
                
                TableColumn inductores = new TableColumn("Inductores");
                inductores.setMinWidth(200);
                inductores.setCellValueFactory(
                        new PropertyValueFactory<>("inductores"));
                
                TableColumn voltaje = new TableColumn("Voltaje");
                voltaje.setMinWidth(200);
                voltaje.setCellValueFactory(
                        new PropertyValueFactory<>("voltaje"));
                
                TableColumn puertas = new TableColumn("Puertas");
                puertas.setMinWidth(200);
                puertas.setCellValueFactory(
                        new PropertyValueFactory<>("cantidadPuertas"));
                
                TableColumn capacidad = new TableColumn("Capacidad");
                capacidad.setMinWidth(200);
                capacidad.setCellValueFactory(
                        new PropertyValueFactory<>("capacidad"));
                
                TableColumn filtro = new TableColumn("Filtro Agua");
                filtro.setMinWidth(200);
                filtro.setCellValueFactory(
                        new PropertyValueFactory<>("filtroAgua"));
                
                TableColumn temp = new TableColumn("Niveles Temperatura");
                temp.setMinWidth(200);
                temp.setCellValueFactory(
                        new PropertyValueFactory<>("nivelesTemperatura"));
                
                tabla.getColumns().addAll(nombre,descripcion,marca,precio,tamano,potencia,inductores,voltaje,puertas,capacidad,filtro,temp);
            }else {
                showError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelConsultaArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }

        regresar = new Button("REGRESAR");

        regresar.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);

        root.setStyle("-fx-background-color: lavender");
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titulo,tabla,regresar);

    }
    
    public VBox getRoot() {
        return root;
    }
    
    private void setUpButtons() {
        regresar.setOnAction(e -> articuloStage.close());
    }
    
    private void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Se ha producido un error");
        alert.setContentText("El sistema no ha podido mostrar los clientes");
        alert.showAndWait();
    }
    
}

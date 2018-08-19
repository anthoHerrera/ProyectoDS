/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.gerenteViews;

import Controlador.ControllerGerente;
import Modelo.Cliente;
import Modelo.Ctes;
import Vista.SceneOrganizer;
import Vista.adminViews.PanelBusquedaArticulos;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Anthony777
 */
public class PanelGerente {
    private final VBox root;
    private Button articulos, ventas, clientes, cerrarSesion;
    private Label titulo;
    
    public PanelGerente(){
        root = new VBox(50);
        setUp();
        setFunctButtons();
    }
    
    private void setUp(){
        titulo = new Label("Consultas");
        titulo.setFont(Font.font("Cambria", 32));
        
        articulos = new Button("ARTICULOS");
        ventas = new Button("VENTAS");
        clientes = new Button("CLIENTES");
        cerrarSesion = new Button("CERRAR SESION");
                
        articulos.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        ventas.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        clientes.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        cerrarSesion.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, articulos, ventas, clientes, cerrarSesion);
        root.setAlignment(Pos.CENTER);
        
    }

    public VBox getRoot() {
        return root;
    }
    
    private void setFunctButtons() {
        articulos.setOnAction(e -> {
            showArticulos();
        });
        
        articulos.setOnMouseEntered(e -> {
            articulos.setScaleX(1.5);
            articulos.setScaleY(1.5);
        });
        
        articulos.setOnMouseExited(e -> {
            articulos.setScaleX(1);
            articulos.setScaleY(1);
        });
        
        ventas.setOnAction(e ->  {
            showVentas();
        });
        
        ventas.setOnMouseEntered(e -> {
            ventas.setScaleX(1.5);
            ventas.setScaleY(1.5);
        });
        
        ventas.setOnMouseExited(e -> {
            ventas.setScaleX(1);
            ventas.setScaleY(1);
        });
        
        clientes.setOnAction(e -> {
            showClients();
        });
        
        clientes.setOnMouseEntered(e -> {
            clientes.setScaleX(1.5);
            clientes.setScaleY(1.5);
        });
        
        clientes.setOnMouseExited(e -> {
            clientes.setScaleX(1);
            clientes.setScaleY(1);
        });
        
        cerrarSesion.setOnAction(e -> {
            SceneOrganizer.setupScenePrincipal();
        });
        
        cerrarSesion.setOnMouseEntered(e -> {
            cerrarSesion.setScaleX(1.5);
            cerrarSesion.setScaleY(1.5);
        });
        
        cerrarSesion.setOnMouseExited(e -> {
            cerrarSesion.setScaleX(1);
            cerrarSesion.setScaleY(1);
        });
    }
    
    private void showClients() {
        PanelConsultaClientes panel = new PanelConsultaClientes();
    }
    
    private void showArticulos() {
        PanelBusquedaArticulos panel = new PanelBusquedaArticulos();
    }

    private void showVentas() {
        PanelConsultaVentas panel = new PanelConsultaVentas();
    }
    
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Oops!");
        alert.setHeaderText("Not implemented yet.");
        alert.setContentText("Sorry not sorry xd.");
        alert.showAndWait();

    }
    
}

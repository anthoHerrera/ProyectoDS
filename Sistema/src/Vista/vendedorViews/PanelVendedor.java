/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.vendedorViews;

import Vista.vendedorViews.CrearCliente;
import Modelo.Ctes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author JuanJose FS
 */
public class PanelVendedor {
    private VBox root;
    private HBox hbox;
    private Button cotizacion, cliente, venta;
    private Label titulo;
    
    public PanelVendedor(){
        root = new VBox();
        setUp();
    }
    
    private void setUp() {
        root.setPadding(new Insets(20,20,20,20));
        
        titulo = new Label("Vendedor");
	titulo.setFont(new Font("Comic Sans",40));
        
        cotizacion = new Button("Cotizacion");
        cliente = new Button("Registrar cliente");
        venta = new Button("Venta");
        
        setupFunctButtons();
        
        cotizacion.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        cliente.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        venta.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo);
        root.getChildren().addAll(cotizacion,cliente,venta);
    }

    public VBox getRoot() {
        return root;
    }
    
    public void showAlert(){
	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Oops!");
        alert.setHeaderText("Not implemented yet.");
        alert.setContentText("Sorry not sorry xd.");
        alert.showAndWait();

    }
    
    private void setupFunctButtons(){
        cotizacion.setOnAction(e->showAlert());
        cliente.setOnAction(e->crearCliente());
        venta.setOnAction(e->showAlert());
    }
    
    private void crearCliente() {
        CrearCliente crear = new CrearCliente();
    }
    
}

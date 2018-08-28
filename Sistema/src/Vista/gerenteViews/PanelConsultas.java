/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.gerenteViews;

import Modelo.Ctes;
import Vista.adminViews.PanelArticulos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Anthony777
 */
class PanelConsultas {
    private final VBox root;
    private Label titulo;
    private Button articulos, ventas, clientes, regresar;
    private Stage consultaStage;
    private Scene scene;

    public PanelConsultas() {
        root = new VBox(50);
        setPanes();
        setFunctButtons();
        setStage();
    }

    public VBox getRoot() {
        return root;
    }

    private void setPanes() {
        root.setPadding(new Insets(20, 20, 20, 20));
        titulo = new Label("Consultas");
        titulo.setFont(Font.font("Cambria", 32));
        
        articulos = new Button("ARTICULOS");
        ventas = new Button("VENTAS");
        clientes = new Button("CLIENTES");        
        regresar = new Button("REGRESAR");
                
        articulos.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        ventas.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        clientes.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);        
        regresar.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, articulos, ventas, clientes, regresar);
        root.setAlignment(Pos.CENTER);
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
        
        regresar.setOnAction(e -> consultaStage.close());
        
        regresar.setOnMouseEntered(e -> {
            regresar.setScaleX(1.5);
            regresar.setScaleY(1.5);
        });
        
        regresar.setOnMouseExited(e -> {
            regresar.setScaleX(1);
            regresar.setScaleY(1);
        });
    }

    private void setStage() {
        consultaStage = new Stage();
        scene = new Scene(this.getRoot(), Ctes.APP_WIDHT, Ctes.APP_HEIGHT);
        consultaStage.setScene(scene);
        consultaStage.setTitle("Interfaz de consultas de Gerente");
        consultaStage.showAndWait();
    }
    
    private void showClients() {
        PanelConsultaClientes panel = new PanelConsultaClientes();
    }
    
    private void showArticulos() {
        PanelConsultaArticulos panel = new PanelConsultaArticulos();
    }

    private void showVentas() {
        PanelConsultaVentas panel = new PanelConsultaVentas();
    }

}

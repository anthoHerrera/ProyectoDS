/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.adminViews;

import Vista.superViews.PanelSuper;
import Modelo.Ctes;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author JuanjoseFS
 */
public final class PanelInventarioAdmin {

    private final VBox root;
    private Button agregar, eliminar, actualizar, buscar,consultar;
    private Label titulo;
    private Stage inventoryStage;
    private Scene scene;

    public PanelInventarioAdmin() {
        root = new VBox(20);
        setUpButtons();  
        setUp();
        setStage();
    }

    public void setStage() {
        inventoryStage = new Stage();
        scene = new Scene(this.getRoot(), 800, 600);
        inventoryStage.setScene(scene);
        inventoryStage.setTitle("Inventario");
        inventoryStage.setResizable(false);
        inventoryStage.showAndWait();
    }

    public void setUp() {

        root.setPadding(new Insets(20, 20, 20, 20));

        titulo = new Label("Panel de Inventario");
        titulo.setFont(new Font("Comic Sans", 40));

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, buscar, agregar, actualizar, eliminar);

    }

    private void setUpButtons() {
        agregar = new Button("AGREGAR PRODUCTO");
        eliminar = new Button("ELIMINAR PRODUCTO");
        actualizar = new Button("MODIFICAR PRODUCTO");
        buscar = new Button("BUSCAR PRODUCTO");
       
        agregar.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);
        eliminar.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);
        actualizar.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);
        buscar.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);
        
        buscar.setOnAction(e-> new PanelBusquedaArticulos());
        agregar.setOnAction(e -> new PanelAgregaArticulos());
//        eliminar.setOnAction(e -> showAlert());
//        actualizar.setOnAction(e -> showAlert());
        
        
    }

    public Pane getRoot() {
        return root;
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Oops!");
        alert.setHeaderText("Not implemented yet.");
        alert.setContentText("Sorry not sorry xd.");
        alert.showAndWait();

    }

}

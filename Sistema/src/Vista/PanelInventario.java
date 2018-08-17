/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

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
 * @author gabpa
 */
public final class PanelInventario {

    private final VBox root;
    private Button agregarObjeto, eliminarObjetos, modificarObjeto, buscarObjeto, regresar;
    private Label titulo;
    private final PanelSuper panelsuper;
    private Stage inventoryStage;
    private Scene scene;

    public PanelInventario(PanelSuper panelsuper) {
        root = new VBox(20);
        this.panelsuper = panelsuper;
        setupPanes();
        setupFunctButtons();
        setupStage();
    }

    public void setupStage() {
        inventoryStage = new Stage();
        scene = new Scene(this.getRoot(), 800, 400);
        inventoryStage.setScene(scene);
        inventoryStage.setTitle("Inventario");
        inventoryStage.showAndWait();
    }

    public void setupPanes() {

        root.setPadding(new Insets(20, 20, 20, 20));

        titulo = new Label("Panel de Inventario");
        titulo.setFont(new Font("Comic Sans", 40));

        agregarObjeto = new Button("AGREGAR PRODUCTO");
        eliminarObjetos = new Button("ELIMINAR PRODUCTO");
        modificarObjeto = new Button("MODIFICAR PRODUCTO");
        buscarObjeto = new Button("BUSCAR PRODUCTO");
        regresar = new Button("REGRESAR");

        agregarObjeto.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);
        eliminarObjetos.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);
        modificarObjeto.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);
        buscarObjeto.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);
        regresar.setPrefSize(Ctes.BUT_WIDTH + 10, Ctes.BUT_HEIGHT - 10);

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, buscarObjeto, agregarObjeto, modificarObjeto, eliminarObjetos, regresar);

    }

    private void setupFunctButtons() {
        agregarObjeto.setOnAction(e -> showAlert());
        eliminarObjetos.setOnAction(e -> showAlert());
        modificarObjeto.setOnAction(e -> showAlert());
        buscarObjeto.setOnAction(e -> showAlert());
        regresar.setOnAction(e -> inventoryStage.close());
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

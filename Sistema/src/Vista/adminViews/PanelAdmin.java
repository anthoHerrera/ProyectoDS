/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.adminViews;

import Modelo.Ctes;
import Vista.SceneOrganizer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author JuanjoseFS
 */
public final class PanelAdmin {

    private final VBox root;
    private Button inventario, transacciones, bodega, salir;
    private Label titulo;

    public PanelAdmin() {
        root = new VBox(20);
        setUpButtons();
        setUp();
    }

    public void setUp() {

        root.setPadding(new Insets(20, 20, 20, 20));

        titulo = new Label("Bienvenido administrador");
        titulo.setFont(new Font("Comic Sans", 36));

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, inventario, transacciones, bodega, salir);

    }

    private void setUpButtons() {
        
        inventario = new Button("PRODUCTOS");
        transacciones = new Button("VENTAS");
        bodega = new Button("BODEGA");
        salir = new Button("CERRAR SESION");

        inventario.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        transacciones.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        bodega.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        salir.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);

        inventario.setOnAction(e -> new PanelInventarioAdmin());
        salir.setOnAction(e -> SceneOrganizer.setupScenePrincipal());
    }

    public Pane getRoot() {
        return root;
    }

}

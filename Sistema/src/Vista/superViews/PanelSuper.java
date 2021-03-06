/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.superViews;

import Modelo.Ctes;
import Strategy.reportes.ReporteVentasSemanales;
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
 * @author gabpa
 */
public final class PanelSuper {

    private final VBox root;
    private Button inventario, transacciones,reportes, bodega, salir;
    private Label titulo;

    public PanelSuper() {
        root = new VBox(20);
        setupPanes();
        setupFunctButtons();
    }

    public void setupPanes() {

        root.setPadding(new Insets(20, 20, 20, 20));

        titulo = new Label("Hola Crack!");
        titulo.setFont(new Font("Comic Sans", 36));

        inventario = new Button("INVENTARIO");
        transacciones = new Button("TRANSACCIONES");
		reportes = new Button("REPORTES");
        bodega = new Button("BODEGA");
        salir = new Button("CERRAR SESION");

        inventario.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
		reportes.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        transacciones.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        bodega.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        salir.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, inventario, transacciones,reportes, bodega, salir);

    }

    private void setupFunctButtons() {

        inventario.setOnAction(e -> new PanelInventarioSuper(this));
		reportes.setOnAction(e-> new ReporteVentasSemanales());
        salir.setOnAction(e -> SceneOrganizer.setupScenePrincipal());
    }

    public Pane getRoot() {
        return root;
    }

}

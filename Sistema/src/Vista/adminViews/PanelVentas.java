/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.adminViews;

import Vista.gerenteViews.*;
import Controlador.ControllerGerente;
import Modelo.Ctes;
import Modelo.Transaccion;
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
public class PanelVentas {
    private final VBox root;
    private Label titulo;
    private Button regresar;
    private ControllerGerente controlador;
    private ObservableList<Transaccion> ventas;
    private TableView<Transaccion> tabla;
    private Stage ventaStage;
    private Scene scene;

    public PanelVentas() {
        root = new VBox(10);
        setPanes();
        setFunctButtons();
        setStage();
    }

    private void setPanes() {
        root.setPadding(new Insets(20, 20, 20, 20));
        controlador = new ControllerGerente();
        tabla = new TableView<>();
        titulo = new Label("Ventas");
        titulo.setFont(new Font("Cambria", 40));

        try {
            ventas = controlador.consultaVentas();
            if (ventas != null) {
                tabla.setItems(ventas);
                tabla.setEditable(false);
                
                TableColumn idT = new TableColumn("idTransaccion");
                idT.setMinWidth(200);
                idT.setCellValueFactory(
                        new PropertyValueFactory<>("idTransaccion"));
                
                TableColumn type = new TableColumn("tipo");
                type.setMinWidth(200);
                type.setCellValueFactory(
                        new PropertyValueFactory<>("tipo"));
                
                TableColumn ide = new TableColumn("idEmpleado");
                ide.setMinWidth(200);
                ide.setCellValueFactory(
                        new PropertyValueFactory<>("idEmpleado"));
                
                TableColumn idc = new TableColumn("idCliente");
                idc.setMinWidth(200);
                idc.setCellValueFactory(
                        new PropertyValueFactory<>("idCliente"));
                
                TableColumn visible = new TableColumn("isVisible");
                visible.setMinWidth(200);
                visible.setCellValueFactory(
                        new PropertyValueFactory<>("isVisible"));
                tabla.getColumns().addAll(idT, type, ide, idc, visible);
            }else {
                showError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelVentas.class.getName()).log(Level.SEVERE, null, ex);
        }

        regresar = new Button("REGRESAR");

        regresar.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);

        root.setStyle("-fx-background-color: lavender");
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titulo,tabla,regresar);
    }

    private void setFunctButtons() {
        regresar.setOnAction(e -> ventaStage.close());
    }

    private void setStage() {
        ventaStage = new Stage();
        scene = new Scene(this.getRoot(), Ctes.APP_WIDHT - 200, Ctes.APP_HEIGHT - 250);
        ventaStage.setScene(scene);
        ventaStage.setTitle("Consulta ventas");
        ventaStage.showAndWait();
    }

    private VBox getRoot() {
        return root;
    }
    
    private void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Se ha producido un error");
        alert.setContentText("El sistema no ha podido mostrar las ventas");
        alert.showAndWait();
    }
    
}

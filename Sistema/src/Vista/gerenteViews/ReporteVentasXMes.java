/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.gerenteViews;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Anthony777
 */
public class ReporteVentasXMes {
    private final VBox root;
    private HBox con;
    private Label titulo, ingreso;
    private Button regresar, boton;
    private ControllerGerente controlador;
    private ObservableList<Transaccion> ventas;
    private TableView<Transaccion> tabla;
    private Stage ventaStage;
    private Scene scene;
    private ComboBox<String> mes;

    public ReporteVentasXMes() {
        root = new VBox(10);
        setUpComboBoxes();
        setPanes();
        setFunctButtons();
        setStage();
    }
    
    private void setUpComboBoxes() {
        mes = new ComboBox<>();
        mes.getItems().addAll("Enero", "Febrero", "Marzo", "Abril","Mayo","Junio",
                "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
    }
    
    private void setPanes() {
        root.setPadding(new Insets(20, 20, 20, 20));
        controlador = new ControllerGerente();
        tabla = new TableView<>();
        titulo = new Label("Ventas por mes");
        titulo.setFont(new Font("Cambria", 40));
        con = new HBox(5);
        ingreso = new Label("REPORTE");
        boton = new Button("Mostrar");
        con.getChildren().addAll(ingreso,mes,boton);
        regresar = new Button("REGRESAR");

        regresar.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);

        root.setStyle("-fx-background-color: lavender");
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titulo,con,tabla,regresar);
    }

    private void setFunctButtons() {
        regresar.setOnAction(e -> ventaStage.close());
        boton.setOnAction(e -> manejarMes());
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
    
    private void manejarMes() {
        if (mes.getValue() != null) {
            switch (mes.getValue()) {
                case "Enero":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-01-01' "
                            + "and fecha <= '2018-01-31' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Febrero":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-02-01' "
                            + "and fecha <= '2018-02-28' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Marzo":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-03-01' "
                            + "and fecha <= '2018-03-31' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Abril":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-04-01' "
                            + "and fecha <= '2018-04-30' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Mayo":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-05-01' "
                            + "and fecha <= '2018-05-31' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Junio":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-06-01' "
                            + "and fecha <= '2018-06-30' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Julio":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-07-01' "
                            + "and fecha <= '2018-07-31' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Agosto":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-08-01' "
                            + "and fecha <= '2018-08-31' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Septiembre":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-09-01' "
                            + "and fecha <= '2018-09-30' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Octubre":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-10-01' "
                            + "and fecha <= '2018-10-31' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Noviembre":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-11-01' "
                            + "and fecha <= '2018-11-30' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                case "Diciembre":
                    root.getChildren().clear();
                    tabla.getColumns().clear();
                    generarTabla("select * from transaccion where fecha >= '2018-12-01' "
                            + "and fecha <= '2018-12-31' and tipo = 'venta'");
                    root.getChildren().addAll(titulo, con, tabla, regresar);
                    break;
                
                default:
                    break;
            }
        } else {
            showAlert();
        }

    }
    
    private void generarTabla(String comando) {

        try {
            ventas = controlador.consultaVentasXMes(comando);
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

                
            } else {
                showError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteVentasXMes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Seleccciona un opcion");
        alert.setContentText("El sistema requiere que se seleccione una opcion");
        alert.showAndWait();
    }
}

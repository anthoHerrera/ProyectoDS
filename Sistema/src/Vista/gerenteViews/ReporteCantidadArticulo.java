/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.gerenteViews;

import Controlador.ControllerGerente;
import Modelo.Ctes;
import Modelo.Rarticulo;
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
public class ReporteCantidadArticulo {
    private final VBox root;
    private Label titulo;
    private Button regresar;
    private ControllerGerente controlador;
    private ObservableList<Rarticulo> narticulo;
    private TableView<Rarticulo> tabla;
    private Stage narticuloStage;
    private Scene scene;

    public ReporteCantidadArticulo() {
        root = new VBox(10);
        setPanes();
        setFunctButtons();
        setStage();
    }

    private void setPanes() {
        root.setPadding(new Insets(20, 20, 20, 20));
        controlador = new ControllerGerente();
        tabla = new TableView<>();
        titulo = new Label("Cantidad de Articulos");
        titulo.setFont(new Font("Cambria", 40));

        try {
            narticulo = controlador.consultaNArticulos();
            if (narticulo != null) {
                tabla.setItems(narticulo);
                tabla.setEditable(false);
                
                TableColumn id = new TableColumn("idArticulo");
                id.setMinWidth(200);
                id.setCellValueFactory(
                        new PropertyValueFactory<>("idArticulo"));
                
                TableColumn name = new TableColumn("Nombre");
                name.setMinWidth(200);
                name.setCellValueFactory(
                        new PropertyValueFactory<>("nombre"));
                
                TableColumn des = new TableColumn("Descripcion");
                des.setMinWidth(200);
                des.setCellValueFactory(
                        new PropertyValueFactory<>("descripcion"));
                
                TableColumn mark = new TableColumn("Marca");
                mark.setMinWidth(200);
                mark.setCellValueFactory(
                        new PropertyValueFactory<>("marca"));
                
                TableColumn price = new TableColumn("Precio");
                price.setMinWidth(200);
                price.setCellValueFactory(
                        new PropertyValueFactory<>("precio"));
                
                TableColumn n = new TableColumn("Cantidad");
                n.setMinWidth(200);
                n.setCellValueFactory(
                        new PropertyValueFactory<>("cantidadArticulo"));
                tabla.getColumns().addAll(id, name, des, mark, price, n);
            }else {
                showError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteCantidadArticulo.class.getName()).log(Level.SEVERE, null, ex);
        }

        regresar = new Button("REGRESAR");

        regresar.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);

        root.setStyle("-fx-background-color: lavender");
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titulo,tabla,regresar);
    }

    private void setFunctButtons() {
        regresar.setOnAction(e -> narticuloStage.close());
    }

    private void setStage() {
        narticuloStage = new Stage();
        scene = new Scene(this.getRoot(), Ctes.APP_WIDHT - 200, Ctes.APP_HEIGHT - 250);
        narticuloStage.setScene(scene);
        narticuloStage.setTitle("Reporte de cantidad de articulos");
        narticuloStage.showAndWait();
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

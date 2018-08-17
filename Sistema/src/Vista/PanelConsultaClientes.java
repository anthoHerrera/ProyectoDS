/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerGerente;
import Modelo.Cliente;
import Modelo.Ctes;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Anthony777
 */
public final class PanelConsultaClientes {
    private final VBox root;
    private Label titulo;
    private Button regresar;
    private ControllerGerente controlador;
    private ObservableList<Cliente> clientes;
    private TableView<Cliente> tabla;
    private final PanelGerente manager;
    private Stage clientStage;
    private Scene scene;

    public PanelConsultaClientes(PanelGerente manager) {
        this.manager = manager;
        root = new VBox(10);
        setPanes();
        setFunctButtons();
        setStage();
    }
    
    public void setStage() {
        clientStage = new Stage();
        scene = new Scene(this.getRoot(), Ctes.APP_WIDHT - 200, Ctes.APP_HEIGHT - 250);
        clientStage.setScene(scene);
        clientStage.setTitle("Consulta clientes");
        clientStage.showAndWait();
    }

    public void setPanes() {
        
        root.setPadding(new Insets(20, 20, 20, 20));
        controlador = new ControllerGerente();
        tabla = new TableView<>();
        titulo = new Label("Clientes");
        titulo.setFont(new Font("Cambria", 40));

        try {
            clientes = controlador.consultaClientes();
            if (clientes != null) {
                tabla.setItems(clientes);
                tabla.setEditable(false);
                
                TableColumn cedula = new TableColumn("cedula");
                cedula.setMinWidth(200);
                cedula.setCellValueFactory(
                        new PropertyValueFactory<>("cedula"));
                
                TableColumn nombre = new TableColumn("nombre");
                nombre.setMinWidth(200);
                nombre.setCellValueFactory(
                        new PropertyValueFactory<>("nombre"));
                
                TableColumn telefono = new TableColumn("telefono");
                telefono.setMinWidth(200);
                telefono.setCellValueFactory(
                        new PropertyValueFactory<>("telefono"));
                
                TableColumn visible = new TableColumn("isVisible");
                visible.setMinWidth(200);
                visible.setCellValueFactory(
                        new PropertyValueFactory<>("isVisible"));
                tabla.getColumns().addAll(cedula,nombre,telefono,visible);
            }else {
                showError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PanelConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        regresar = new Button("REGRESAR");

        regresar.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);

        root.setStyle("-fx-background-color: lavender");
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titulo,tabla,regresar);

    }
    
    public VBox getRoot() {
        return root;
    }
    
    private void setFunctButtons() {
        regresar.setOnAction(e -> clientStage.close());
    }
    
    private void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Se ha producido un error");
        alert.setContentText("El sistema no ha podido mostrar los clientes");
        alert.showAndWait();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.adminViews;

import Controlador.ControllerAdmin;
import Modelo.Ctes;
import Modelo.FactoryMethod.Articulo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author JuanJose FS
 */
public class PanelEliminarArticulos {
    private PanelBusquedaArticulos panel;
    private ComboBox<String> combo;
    private BorderPane root;
    private HBox hbox;
    private Button eliminar;
    private ControllerAdmin controlador;
    private Stage eliminarStage;
    private Scene scene;
    
    public PanelEliminarArticulos(PanelBusquedaArticulos panel){
        this.panel = panel;
        root = new BorderPane();
        controlador = new ControllerAdmin();
        setUp();
        setStage();
    }
    
    public void setStage() {
        eliminarStage = new Stage();
        scene = new Scene(this.getRoot(), Ctes.APP_WIDHT-600, Ctes.APP_HEIGHT - 550);
        eliminarStage.setScene(scene);
        eliminarStage.setTitle("Eliminar Articulos");
        eliminarStage.setResizable(false);
        eliminarStage.showAndWait();
    }
    
    private void setUp(){
        combo = new ComboBox<>();
        for(Articulo art : panel.getLista()){
            combo.getItems().addAll(art.getIdArticulo());
        }
        eliminar = new Button("Eliminar articulo");
        eliminar.setOnAction(e-> {
            try {
                manejarEliminar();
            } catch (SQLException ex) {
                Logger.getLogger(PanelEliminarArticulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.setCenter(combo);
        hbox = new HBox(30);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(eliminar);
        root.setBottom(hbox);
        root.setStyle("-fx-background-color: lavender");
        
    }
    
    private void manejarEliminar() throws SQLException{
        if(combo.getValue()!=null){
            Alert a = showAlert(combo.getValue());
            if(!a.getResult().getButtonData().isCancelButton()){
                controlador.eliminaArticulo(combo.getValue());
                showInfo(combo.getValue());
                eliminarStage.close();
            }
        }else{
            showAlertERROR();
        }
    }
    
    private void showInfo(String id){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Eliminacion realizada ");
        alert.setContentText("Acaba de eliminar el articulo "+id);
        alert.showAndWait();
    }
    
    private Alert showAlert(String id) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion");
        alert.setHeaderText("Esta a punto de eliminar el articulo "+id);
        alert.setContentText("Desea continuar con el proceso?");
        alert.showAndWait();
        return alert;
    }
    
    private void showAlertERROR() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Advertencia");
        alert.setHeaderText("Seleccciona un opcion");
        alert.setContentText("El sistema requiere que se seleccione una opcion");
        alert.showAndWait();
    }
    
    public BorderPane getRoot() {
        return root;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author JuanJose FS
 */
public class PanelAdmin {
    private Pane root;
    private Button crearProd, crearVenta;
    private TableView productos, ventas;
    private VBox vbox;
    private HBox hbox,buttons;
    
    public PanelAdmin(){
        root = new Pane();
        setUpButtons();
    }
    
    private void setUpButtons(){
        vbox = new VBox();
        buttons = new HBox();
        crearProd = new Button("Crear producto");
        crearVenta = new Button("Crear venta");
        buttons.getChildren().addAll(crearProd,crearVenta);
        vbox.getChildren().add(buttons);
        root.getChildren().add(vbox);
        crearProd.setOnAction(e-> new CreacionProducto());
    }
    
    public Pane getRoot() {
        return root;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author JuanJose FS
 */
public class PanelVendedor {
    private VBox root;
    private HBox hbox;
    private Button cotizacion, cliente, venta;
    
    public PanelVendedor(){
        root = new VBox();
        setUp();
    }
    
    private void setUp() {
        hbox= new HBox();
        cotizacion = new Button("Cotizacion");
        cliente = new Button("Registrar cliente");
        venta = new Button("Venta");
        hbox.getChildren().addAll(cotizacion,cliente,venta);
        root.getChildren().add(hbox);
    }

    public VBox getRoot() {
        return root;
    }
    
}

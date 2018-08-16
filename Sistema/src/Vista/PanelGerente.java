/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Anthony777
 */
public class PanelGerente {
    private VBox root;
    private Button articulos, ventas, clientes;
    
    public PanelGerente(){
        root = new VBox(20);
        setUp();
    }
    
    private void setUp(){
        
        articulos = new Button("Consultar reporte de articulos");
        ventas = new Button("Consultar reporte de ventas");
        clientes = new Button("Consultar reporte de clientes");
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(articulos, ventas, clientes);
        root.setAlignment(Pos.CENTER);
        
    }

    public VBox getRoot() {
        return root;
    } 
    
}

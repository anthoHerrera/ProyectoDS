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
import javafx.stage.Stage;

/**
 *
 * @author JuanJose FS
 */
public class PanelGerente {
    private VBox root;
    private HBox hbox;
    private Button consultas, reportes;
    
    public PanelGerente(){
        root = new VBox();
        setUp();
    }
    
    private void setUp(){
        hbox= new HBox();
        consultas = new Button("Consultar productos");
        reportes = new Button("Hacer reporte");
        hbox.getChildren().addAll(consultas,reportes);
        root.getChildren().add(hbox);
        
    }

    public VBox getRoot() {
        return root;
    } 
    
}

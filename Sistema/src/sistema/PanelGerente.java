/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author JuanJose FS
 */
public class PanelGerente {
    private Stage creacion;
    private Pane root;
    private HBox hbox;
    private Button consultas, reportes;
    
    public PanelGerente(){
        root = new Pane();
        creacion = new Stage();
        creacion.setResizable(false);
        creacion.setTitle("Interfaz Gerente");

        creacion.initModality(Modality.WINDOW_MODAL);
        creacion.initOwner(Sistema.mainStage);

        Scene scene = new Scene(root, 1500, 750);
        creacion.setScene(scene);

        setUp();
        
        creacion.showAndWait();
        
    }
    
    private void setUp(){
        hbox= new HBox();
        consultas = new Button("Consultar productos");
        reportes = new Button("Hacer reporte");
        hbox.getChildren().addAll(consultas,reportes);
        root.getChildren().add(hbox);
        
    }
    
}

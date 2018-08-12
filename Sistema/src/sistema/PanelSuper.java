/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author JuanJose FS
 */
public class PanelSuper {
    private Stage creacion;
    private Pane root;
    
    public PanelSuper(){
        root = new Pane();
        creacion = new Stage();
        creacion.setResizable(false);
        creacion.setTitle("Interfaz SuperAdministrador");

        creacion.initModality(Modality.WINDOW_MODAL);
        creacion.initOwner(Sistema.mainStage);

        Scene scene = new Scene(root, 1500, 750);
        creacion.setScene(scene);

        creacion.showAndWait();
    }
    
}

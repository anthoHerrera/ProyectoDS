/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author JuanJose FS
 */
public class PanelSuper {
    private Pane root;
    
    public PanelSuper(){
        root = new Pane();      
    }

    public Pane getRoot() {
        return root;
    }
    
    
    
}

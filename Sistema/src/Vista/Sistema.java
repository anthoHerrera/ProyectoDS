/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Anthony777
 */
public class Sistema extends Application {
    public static Stage mainStage;
    
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        PanelPrincipal p = new PanelPrincipal();
        Scene scene = new Scene(p.getRoot(), 1000, 750);  
        primaryStage.setResizable(false);
        primaryStage.setTitle("Sistema");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

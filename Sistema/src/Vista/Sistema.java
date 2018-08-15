/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Anthony777
 */
public class Sistema extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        SceneOrganizer organizer = new SceneOrganizer(primaryStage);
        organizer.getWindow().setTitle("Sistema");
        organizer.getWindow().setResizable(false);
        organizer.getWindow().show();
        organizer.getWindow().setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.exit(0);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

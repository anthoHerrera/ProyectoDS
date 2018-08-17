/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.gerenteViews.PanelGerente;
import Vista.superViews.PanelSuper;
import Modelo.Ctes;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Anthony777
 */
public class SceneOrganizer {
    private static Stage window;
    private static Scene scenePrincipal,sceneSuper,sceneGerente,sceneAdmin,sceneVendedor;
    
    public SceneOrganizer(Stage stage) {
        window = stage;
        setupScenePrincipal();
    }

    public Stage getWindow() {
        return window;
    }
    
    public static void setupScenePrincipal() {
        scenePrincipal = new Scene(new PanelPrincipal().getRoot(),Ctes.APP_LW,Ctes.APP_LH);
        window.setTitle("Sistema");
        window.setScene(scenePrincipal);
    }
    
    public static void setupSceneSuper() {
        sceneSuper = new Scene(new PanelSuper().getRoot(),Ctes.APP_WIDHT,Ctes.APP_HEIGHT);
        window.setTitle("Interfaz SuperAdministrador");
        window.setScene(sceneSuper);
    }
    
    public static void setupSceneGerente() {
        sceneGerente = new Scene(new PanelGerente().getRoot(),Ctes.APP_WIDHT,Ctes.APP_HEIGHT);
        window.setTitle("Interfaz Gerente");
        window.setScene(sceneGerente);
    }
    
    public static void setupSceneAdmin() {
        sceneAdmin = new Scene(new PanelAdmin().getRoot(),Ctes.APP_WIDHT,Ctes.APP_HEIGHT);
        window.setTitle("Interfaz Administrador");
        window.setScene(sceneAdmin);
    }
    
    public static void setupSceneVendedor() {
        sceneVendedor = new Scene(new PanelVendedor().getRoot(),Ctes.APP_WIDHT,Ctes.APP_HEIGHT);
        window.setTitle("Interfaz Vendedor");
        window.setScene(sceneVendedor);
    }
}

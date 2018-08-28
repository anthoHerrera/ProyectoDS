/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.gerenteViews;

import Modelo.Ctes;
import Vista.SceneOrganizer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Anthony777
 */
public class PanelGerente {
    private final VBox root;
    private Button consultas, reportes, cerrarSesion;
    private Label titulo;
    
    public PanelGerente(){
        root = new VBox(50);
        setUp();
        setFunctButtons();
    }
    
    private void setUp(){
        titulo = new Label("Opciones del Gerente");
        titulo.setFont(Font.font("Cambria", 32));
        
        consultas = new Button("CONSULTAS");
        reportes = new Button("REPORTES");
        cerrarSesion = new Button("CERRAR SESION");
                
        consultas.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        reportes.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        cerrarSesion.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, consultas, reportes, cerrarSesion);
        root.setAlignment(Pos.CENTER);
        
    }

    public VBox getRoot() {
        return root;
    }
    
    private void setFunctButtons() {
        consultas.setOnAction(e -> {
            showConsultas();
        });
        
        consultas.setOnMouseEntered(e -> {
            consultas.setScaleX(1.5);
            consultas.setScaleY(1.5);
        });
        
        consultas.setOnMouseExited(e -> {
            consultas.setScaleX(1);
            consultas.setScaleY(1);
        });
        
        reportes.setOnAction(e ->  {
            showReportes();
        });
        
        reportes.setOnMouseEntered(e -> {
            reportes.setScaleX(1.5);
            reportes.setScaleY(1.5);
        });
        
        reportes.setOnMouseExited(e -> {
            reportes.setScaleX(1);
            reportes.setScaleY(1);
        });
        
        cerrarSesion.setOnAction(e -> {
            SceneOrganizer.setupScenePrincipal();
        });
        
        cerrarSesion.setOnMouseEntered(e -> {
            cerrarSesion.setScaleX(1.5);
            cerrarSesion.setScaleY(1.5);
        });
        
        cerrarSesion.setOnMouseExited(e -> {
            cerrarSesion.setScaleX(1);
            cerrarSesion.setScaleY(1);
        });
    }
    
    
    private void showConsultas() {
        PanelConsultas panel = new PanelConsultas();
    }
    
    private void showReportes() {
        PanelReportes panel = new PanelReportes();
    }
    
}

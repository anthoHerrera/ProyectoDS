/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.adminViews;

import Modelo.Ctes;
import Vista.SceneOrganizer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author JuanjoseFS
 */
public final class PanelAgregaArticulos {

    private final VBox root;
    private VBox lavadora,cocina,refri;
    private HBox hbox;
    private Label lav,coc,ref;
    private Button lav70200, lav75, lav1786, andalucia, ginebra, refri235, refri250;
    private Label titulo;
    private Stage addarticuloStage;
    private Scene scene;

    public PanelAgregaArticulos() {
        root = new VBox(20);
        setUpButtons();
        setUp();
        setStage();
    }
    
    public void setStage() {
        addarticuloStage = new Stage();
        scene = new Scene(this.getRoot(), Ctes.APP_WIDHT - 200, Ctes.APP_HEIGHT - 50);
        addarticuloStage.setScene(scene);
        addarticuloStage.setTitle("Agregar articulos");
        addarticuloStage.setResizable(false);
        addarticuloStage.showAndWait();
    }

    public void setUp() {

        root.setPadding(new Insets(20, 20, 20, 20));

        titulo = new Label("Agregar Articulos");
        titulo.setFont(new Font("Comic Sans", 36));
        
        cocina = new VBox(20);
        coc = new Label("Cocinas de induccion");
        titulo.setFont(new Font("Comic Sans", 24));
        cocina.getChildren().addAll(coc,andalucia,ginebra);
        cocina.setAlignment(Pos.CENTER);
        
        lavadora = new VBox(20);
        lav = new Label("Lavadoras");
        titulo.setFont(new Font("Comic Sans", 24));
        lavadora.getChildren().addAll(lav,lav70200,lav75,lav1786);
        lavadora.setAlignment(Pos.CENTER);
        
        refri = new VBox(20);
        ref = new Label("Refrigeradoras");
        titulo.setFont(new Font("Comic Sans", 24));
        refri.getChildren().addAll(ref,refri235,refri250);
        refri.setAlignment(Pos.CENTER);
        
        hbox = new HBox(20);
        hbox.getChildren().addAll(cocina,lavadora,refri);
        
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, hbox);

    }

    private void setUpButtons() {
        
        lav70200 = new Button("LAVADORA LMA70300WGAB0");
        lav75 = new Button("LAVADORA LMD75B0 ");
        lav1786 = new Button("LAVADORA WMC1786SXWW3");
        andalucia = new Button("COCINA DE INDUCCION ANDALUCIA");
        ginebra = new Button("COCINA DE INDUCCION GINEBRA");
        refri235 = new Button("REFRIGERADORA RDE235UWAB");
        refri250 = new Button("REFRIGERADORA RDE250FXJB");

        lav70200.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        lav75.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        lav1786.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        andalucia.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        ginebra.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        refri235.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        refri250.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
        
        lav70200.setOnAction(e-> manejarLav1());

    }
    private void manejarLav1(){
        
    }
    
    public Pane getRoot() {
        return root;
    }

}

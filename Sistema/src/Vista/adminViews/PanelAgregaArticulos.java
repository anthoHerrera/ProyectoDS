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
import javafx.scene.control.TextField;
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
    private HBox hbox,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13;
    private Label titulo,lav,coc,ref,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    private TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    private Button lav70200, lav75, lav1786, andalucia, ginebra, refri235, refri250;
    private Stage addarticuloStage;
    private Scene scene;

    public PanelAgregaArticulos() {
        root = new VBox(20);
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

        root.setPadding(new Insets(10, 10, 10, 10));

        titulo = new Label("Agregar Articulos");
        titulo.setFont(new Font("Comic Sans", 36));
        
        HBox h1 = new HBox(10);HBox h2 = new HBox(10);HBox h3 = new HBox(10);HBox h4 = new HBox(10);
        HBox h5 = new HBox(10);HBox h6 = new HBox(10);HBox h7 = new HBox(10);HBox h8 = new HBox(10);
        HBox h9 = new HBox(10);HBox h10 = new HBox(10);HBox h11 = new HBox(10);HBox h12 = new HBox(10);    
        
        Label l1 = new Label("Nombre:");Label l2 = new Label("Descripcion:");Label l3 = new Label("Marca:");Label l4 = new Label("Precio:");
        Label l5 = new Label("Tamano:");Label l6 = new Label("Potencia total:");Label l7 = new Label("Inductores:");
        Label l8 = new Label("Voltaje:");Label l9 = new Label("Cantidad de puertas:");Label l10 = new Label("Capacidad:");
        Label l11 = new Label("Filtro de agua:");Label l12 = new Label("Niveles de temperatura:");
        
        TextField t1 = new TextField();TextField t2 = new TextField();TextField t3 = new TextField();TextField t4 = new TextField();
        TextField t5 = new TextField();TextField t6 = new TextField();TextField t7 = new TextField();TextField t8 = new TextField();
        TextField t9 = new TextField();TextField t10 = new TextField();TextField t11 = new TextField();TextField t12 = new TextField();
        
        h1.getChildren().addAll(l1,t1);h2.getChildren().addAll(l2,t2);h3.getChildren().addAll(l3,t3);h4.getChildren().addAll(l4,t4);
        h5.getChildren().addAll(l5,t5);h6.getChildren().addAll(l6,t6);h7.getChildren().addAll(l7,t7);h8.getChildren().addAll(l8,t8);
        h9.getChildren().addAll(l9,t9);h10.getChildren().addAll(l10,t10);h11.getChildren().addAll(l11,t11);h12.getChildren().addAll(l12,t12);
        
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
//        cocina = new VBox(20);
//        coc = new Label("Cocinas de induccion");
//        titulo.setFont(new Font("Comic Sans", 24));
//        cocina.getChildren().addAll(coc,andalucia,ginebra);
//        cocina.setAlignment(Pos.CENTER);
//        
//        lavadora = new VBox(20);
//        lav = new Label("Lavadoras");
//        titulo.setFont(new Font("Comic Sans", 24));
//        lavadora.getChildren().addAll(lav,lav70200,lav75,lav1786);
//        lavadora.setAlignment(Pos.CENTER);
//        
//        refri = new VBox(20);
//        ref = new Label("Refrigeradoras");
//        titulo.setFont(new Font("Comic Sans", 24));
//        refri.getChildren().addAll(ref,refri235,refri250);
//        refri.setAlignment(Pos.CENTER);
//        
//        hbox = new HBox(20);
//        hbox.getChildren().addAll(cocina,lavadora,refri);
//        
//        root.setAlignment(Pos.CENTER);
//        root.setStyle("-fx-background-color: lavender");
//        root.getChildren().addAll(titulo, hbox);

    }

//    private void setUpButtons() {
//        
//        lav70200 = new Button("LAVADORA LMA70300WGAB0");
//        lav75 = new Button("LAVADORA LMD75B0 ");
//        lav1786 = new Button("LAVADORA WMC1786SXWW3");
//        andalucia = new Button("COCINA DE INDUCCION ANDALUCIA");
//        ginebra = new Button("COCINA DE INDUCCION GINEBRA");
//        refri235 = new Button("REFRIGERADORA RDE235UWAB");
//        refri250 = new Button("REFRIGERADORA RDE250FXJB");
//
//        lav70200.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
//        lav75.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
//        lav1786.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
//        andalucia.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
//        ginebra.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
//        refri235.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
//        refri250.setPrefSize(Ctes.BUT_WIDTH, Ctes.BUT_HEIGHT);
//        
//        lav70200.setOnAction(e-> manejarLav1());
//
//    }
    private void manejarLav1(){
        
    }
    
    public Pane getRoot() {
        return root;
    }

}

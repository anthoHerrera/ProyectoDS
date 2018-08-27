/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.adminViews;

import Controlador.ControllerAdmin;
import Modelo.Ctes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
 * @author JuanJose FS
 */
public class PanelEditarArticuloEspecifico {
    
    private final VBox root;
    private HBox h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13;
    private Label titulo,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    private TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    private Button agregar,regresar;
    private Scene scene;
    private ControllerAdmin controlador;
    private PanelModificarArticulos p;
    
    public PanelEditarArticuloEspecifico(PanelModificarArticulos p) {
        root = new VBox(20);
        this.p = p;
        setUp();
    }
    
    public void setScene() {
        p.getModificarStage().setScene(p.getScene());
    }

    public void setUp() {
        controlador = new ControllerAdmin();
        root.setPadding(new Insets(10, 10, 10, 10));

        titulo = new Label("Agregar Articulos");
        titulo.setFont(new Font("Comic Sans", 36));
        
        h1 = new HBox(10);h2 = new HBox(10);h3 = new HBox(10);h4 = new HBox(10);
        h5 = new HBox(10);h6 = new HBox(10);h7 = new HBox(10);h8 = new HBox(10);
        h9 = new HBox(10);h10 = new HBox(10);h11 = new HBox(10);h12 = new HBox(10);h13 = new HBox(20);    
        
        l1 = new Label("Nombre:");l2 = new Label("Descripcion:");l3 = new Label("Marca:");l4 = new Label("Precio:");
        l5 = new Label("Tamano:");l6 = new Label("Potencia total:");l7 = new Label("Inductores:");
        l8 = new Label("Voltaje:");l9 = new Label("Cantidad de puertas:");l10 = new Label("Capacidad:");
        l11 = new Label("Filtro de agua:");l12 = new Label("Niveles de temperatura:");
        
        t1 = new TextField();t2 = new TextField();t3 = new TextField();t4 = new TextField();
        t5 = new TextField();t6 = new TextField();t7 = new TextField();t8 = new TextField();
        t9 = new TextField();t10 = new TextField();t11 = new TextField();t12 = new TextField();
        
        agregar = new Button("Agregar articulo");
        regresar = new Button("Regresar");
        
        h1.getChildren().addAll(l1,t1);h2.getChildren().addAll(l2,t2);h3.getChildren().addAll(l3,t3);h4.getChildren().addAll(l4,t4);
        h5.getChildren().addAll(l5,t5);h6.getChildren().addAll(l6,t6);h7.getChildren().addAll(l7,t7);h8.getChildren().addAll(l8,t8);
        h9.getChildren().addAll(l9,t9);h10.getChildren().addAll(l10,t10);h11.getChildren().addAll(l11,t11);h12.getChildren().addAll(l12,t12);
        h13.getChildren().addAll(agregar,regresar);
        
        
        
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12,h13);
        
        agregar.setOnAction(e-> {
            try {
                manejarIngreso();
            } catch (SQLException ex) {
                Logger.getLogger(PanelAgregaArticulos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        regresar.setOnAction(e-> setScene());
        
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

    private void manejarIngreso() throws SQLException{
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("La informacion esta correcta?");
        a.setHeaderText("Esta a punto de ingresar este articulo");
        a.setTitle("Confirmacion");
        a.showAndWait();
        if(!a.getResult().getButtonData().isCancelButton()){
            List<String> atributos = agregarTextFields();
            
            if(t1.getText().startsWith("Cocina de induccion")){
                String id = "ci"+controlador.cuentaArticulos("select count(idarticulo) from articulo where nombre like 'Cocina%'");
                controlador.agregaArticulo(atributos,id);
                showAlert(id);
            }
            else if(t1.getText().startsWith("Lavadora")){
                String id = "la"+controlador.cuentaArticulos("select count(idarticulo) from articulo where nombre like 'Lavadora%'");
                controlador.agregaArticulo(atributos,id);
                showAlert(id);
            }
            else if(t1.getText().startsWith("Refrigeradora")){
                String id = "re"+controlador.cuentaArticulos("select count(idarticulo) from articulo where nombre like 'Refrigeradora%'");
                controlador.agregaArticulo(atributos,id);
                showAlert(id);
            }
            else{
                String id = controlador.cuentaArticulos("select count(idarticulo) from articulo where idarticulo like 'otro%'");
                controlador.agregaArticulo(atributos,"otro"+id);
                showAlert("otro"+id);
            }
            setScene();
        }
    }
    
    private void showAlert(String id){
        Alert b = new Alert(Alert.AlertType.INFORMATION);
        b.setContentText("Su id es "+id);
        b.setHeaderText("Se agrego correctamente el articulo.");
        b.showAndWait();    
    }
    
    private List<String> agregarTextFields(){
       List<String> atributos = new ArrayList<>();
       
       atributos.add(t1.getText());atributos.add(t2.getText());atributos.add(t3.getText());atributos.add(t4.getText());atributos.add(t5.getText());
       atributos.add(t6.getText());atributos.add(t7.getText());atributos.add(t8.getText());atributos.add(t9.getText());atributos.add(t10.getText());
       atributos.add(t11.getText());atributos.add(t12.getText());
       
       return atributos;
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

    
    public Pane getRoot() {
        return root;
    }
}

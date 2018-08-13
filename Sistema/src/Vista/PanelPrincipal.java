/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author JuanJose FS
 */
public class PanelPrincipal {
    private Pane root;
    private VBox vbox;
    private HBox hb1,hb2;
    private Label usuario, clave;
    private TextField usertxt, keytxt;
    private Button ingresar;
    
    public PanelPrincipal() {
        root= new Pane();
        setUp();
    }
    
    private void setUp(){
        usuario = new Label("Usuario");
        clave = new Label("Contraseña");
        usertxt = new TextField();
        keytxt = new TextField();
        ingresar = new Button("Ingresar");
        hb1 = new HBox();
        hb2 = new HBox();
        hb1.getChildren().addAll(usuario,usertxt);
        hb2.getChildren().addAll(clave,keytxt);
        vbox = new VBox();
        vbox.getChildren().addAll(hb1,hb2,ingresar);
        root.getChildren().add(vbox);
        ingresar.setOnAction(e-> validarIngreso());
    }

    private void validarIngreso(){
        // datos quemados
        // validar con los datos de la base
        if(usertxt.getText().equals("flores") && keytxt.getText().equals("1234")){
            new PanelAdmin();
        }else if(usertxt.getText().equals("delpino") && keytxt.getText().equals("1234")){
            new PanelSuper();
        }else if(usertxt.getText().equals("herrera") && keytxt.getText().equals("1234")){
            new PanelGerente();
        }else if(usertxt.getText().equals("laso") && keytxt.getText().equals("1234")){
            new PanelVendedor();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error de autentificacion");
            a.showAndWait();
        }
        usertxt.setText("");
        keytxt.setText("");
        
    }
   
    public Pane getRoot() {
        return root;
        
    }

    public void setRoot(Pane root) {
        this.root = root;
    }
    
}

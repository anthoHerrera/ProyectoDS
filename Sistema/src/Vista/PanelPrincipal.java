/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerPrincipal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author JuanJose FS
 * @author Anthony777
 */
public class PanelPrincipal {
    private VBox root;
    private HBox contenedorUsuario;
    private HBox contenedorContraseña;
    private Button login;
    private TextField usuario;
    private PasswordField contraseña;
    private Label user;
    private Label passw;
    private ControllerPrincipal controlador;
    private ImageView img;
    
    public PanelPrincipal() {
        root = new VBox(20);
        setUp();
    }
    
    private void setUp(){
        controlador = new ControllerPrincipal();
        InputStream is;
        try {
            is = Files.newInputStream(Paths.get("Imagen/user.png"));
            img = new ImageView(new Image(is, 200, 200, false, true));
        } catch (IOException ex) {
            Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        contenedorUsuario = new HBox(20);
        user = new Label("User:        ");
        usuario = new TextField();
        usuario.setPromptText("example@lineablancasa.com");
        usuario.setPrefSize(200, 10);
        contenedorUsuario.setAlignment(Pos.CENTER);
        contenedorUsuario.getChildren().addAll(user,usuario);
        
        contenedorContraseña = new HBox(20);
        passw = new Label("Password: ");
        contraseña = new PasswordField();
        contraseña.setPromptText("password");
        contraseña.setPrefSize(200, 10);
        contenedorContraseña.setAlignment(Pos.CENTER);
        contenedorContraseña.getChildren().addAll(passw,contraseña);
        
        login = new Button("Login");
        login.setPrefSize(200, 10);
        login.setOnAction(e -> {
            try {
                String answer = controlador.verificarLogin(usuario.getText(), contraseña.getText());
                if(answer != null) {
                    switch(answer) {
                        case "Gerente":
                            SceneOrganizer.setupSceneGerente();
                            break;
                        case "Super":
                            SceneOrganizer.setupSceneSuper();
                            break;
                        case "Vendedor":
                            SceneOrganizer.setupSceneVendedor();
                            break;
                        case "Administrador":
                            SceneOrganizer.setupSceneAdmin();
                            break;
                        default:
                            break;
                    }
                }else {
                    showError();                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        });
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(img,contenedorUsuario,contenedorContraseña,login);
        
    }
   
    public VBox getRoot() {
        return root;
        
    }

    public void setRoot(VBox root) {
        this.root = root;
    }
    
    private void showError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Login");
        alert.setHeaderText("Se ha producido un error");
        alert.setContentText("Usuario o contraseña incorrectos");
        alert.showAndWait();
        usuario.setText("");
        contraseña.setText("");
    }
    
}

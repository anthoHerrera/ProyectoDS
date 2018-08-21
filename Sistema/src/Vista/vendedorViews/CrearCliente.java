/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.vendedorViews;

import Controlador.ConexionPostgresql;
import Modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class CrearCliente {
    private VBox root;
    private Stage crearCliente;
    private HBox cedulaBox, nombreBox, telefonoBox;
    private Label lblCedula, lblNombre, lblTelefono;
    private TextField cedula, nombre, telefono;
    private Button crear;
    private ConexionPostgresql conexion;
    
    public CrearCliente(){
        
        setUp();
        
        
    }
    
    public void setUp(){
        root = new VBox();
        root.setPadding(new Insets(20,20,20,20));
        
        crearCliente = new Stage();
        crearCliente.setResizable(false);
        crearCliente.setTitle("Ingresar Cliente");
        crearCliente.initModality(Modality.WINDOW_MODAL);
        
        Scene scene = new Scene(root, 400, 400);
        crearCliente.setScene(scene);
        
        setLabels();
        setupTextFields();
        setHBoxes();
        
        crear = new Button("Ingresar");
        crear.setOnAction(e->ingresarCliente(crearCliente()));
        root.getChildren().add(crear);
        
        
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        crearCliente.showAndWait();
        
    }
    
    public void setHBoxes(){
        cedulaBox = new HBox();
        cedulaBox.getChildren().addAll(lblCedula, cedula);
        cedulaBox.setSpacing(24);
        cedulaBox.setAlignment(Pos.CENTER);
        
        nombreBox = new HBox();
        nombreBox.getChildren().addAll(lblNombre, nombre);
        nombreBox.setSpacing(20);
        nombreBox.setAlignment(Pos.CENTER);
        
        telefonoBox = new HBox();
        telefonoBox.getChildren().addAll(lblTelefono, telefono);
        telefonoBox.setSpacing(20);
        telefonoBox.setAlignment(Pos.CENTER);
        
        root.getChildren().addAll(cedulaBox, nombreBox, telefonoBox);
        
    }
    
    private void setupTextFields(){
        cedula = new TextField();
        nombre = new TextField();
        telefono = new TextField();
    }
    
    public void setLabels() {
        lblCedula = new Label("Cedula:");
        lblNombre = new Label("Nombre:");
        lblTelefono = new Label("Telefono:");
    }
    
    public void ingresarCliente(Cliente cliente) {
        conexion = new ConexionPostgresql();
        try {
            PreparedStatement st = conexion.getCnx().prepareStatement("INSERT INTO cliente (cedula, nombre, telefono, isvisible) VALUES (?, ?, ?, ?)");
            st.setString(1, cliente.getCedula());
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getTelefono());
            st.setBoolean(4, cliente.isIsVisible());
            st.executeUpdate();
            st.close();
            crearCliente.close();
        } catch (SQLException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public Cliente crearCliente(){
        return new Cliente(cedula.getText(), nombre.getText(),telefono.getText(), true);
    }
}

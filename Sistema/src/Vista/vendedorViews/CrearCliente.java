/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.vendedorViews;

import Controlador.ConexionPostgresql;
import Modelo.Cedula;
import Modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import Modelo.chain.Vendedor;
import Modelo.chain.VendedorFinder;
import Modelo.chain.VendedorProcessor;
import javafx.scene.control.Alert;

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
    private VendedorProcessor primerVendedor;
    
    public CrearCliente(){
        conexion = new ConexionPostgresql();
        setUp();
        
        
    }
    
    public void setUp(){
        root = new VBox();
        root.setPadding(new Insets(20,20,20,20));
        cargarVendedores();
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
        
        try {
            PreparedStatement st = conexion.getCnx().prepareStatement("INSERT INTO cliente (cedula, nombre, telefono, isvisible) VALUES (?, ?, ?, ?)");
            st.setString(1, cliente.getCedula());
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getTelefono());
            st.setBoolean(4, cliente.isIsVisible());
            st.executeUpdate();
            st.close();
            Vendedor atiende = buscarVendedor();
            System.out.println(atiende.getNombre());
            showAlert(atiende.getNombre());
            crearCliente.close();
        } catch (SQLException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public Cliente crearCliente(){
        return new Cliente(new Cedula(cedula.getText()), nombre.getText(),telefono.getText(), true);
    }
    
    public void cargarVendedores() {
        try {
            PreparedStatement st = conexion.getCnx().prepareStatement("SELECT * FROM usuario WHERE rol = ?");
            st.setString(1, "Vendedor");
            VendedorProcessor processorAnterior = null;
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                Vendedor vendedor = new Vendedor(nombre, telefono);
                System.out.println("nombre: "+nombre+" telefono: "+telefono);
                VendedorProcessor processor = new VendedorFinder(vendedor);
                
                if(processorAnterior != null){
                    processorAnterior.setNext(processor);
                }
                else {
                    this.primerVendedor = processor;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrearCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Vendedor buscarVendedor(){
        return this.primerVendedor.checkFree().getVendedor();
    }
    
    public void showAlert(String nombreVendedor){
	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vendedor asignado");
        alert.setHeaderText("Vendedor asignado:");
        alert.setContentText(nombreVendedor);
        alert.showAndWait();

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Transaccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Anthony777
 */
public class ControllerGerente {
    private final ConexionPostgresql cnx;

    public ControllerGerente() {
        this.cnx = new ConexionPostgresql();
    }
    
    public ObservableList<Cliente> consultaClientes() throws SQLException {
        ObservableList clientes = null;
        ArrayList<Cliente> c = new ArrayList<>();
        PreparedStatement statement = cnx.getCnx().prepareStatement("select * from cliente");
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            Cliente client = new Cliente(result.getString("cedula"), result.getString("nombre"), 
                    result.getString("cedula"), result.getBoolean("isVisible"));
            c.add(client);
        }
        clientes = FXCollections.observableArrayList(c);
        return clientes;
    }

    public ObservableList<Transaccion> consultaVentas() throws SQLException {
        ObservableList ventas = null;
        ArrayList<Transaccion> v = new ArrayList<>();
        PreparedStatement statement = cnx.getCnx().prepareStatement("select * from transaccion where tipo = 'venta'");
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            Transaccion venta = new Transaccion(result.getInt("idTransaccion"), result.getString("tipo"), 
                    result.getDate("fecha"), result.getString("idEmpleado"), 
                    result.getString("idCliente"), result.getBoolean("isVisible"));
            v.add(venta);
        }
        ventas = FXCollections.observableArrayList(v);
        return ventas;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anthony777
 */
public class ControllerPrincipal {
    private final ConexionPostgresql cnx;

    public ControllerPrincipal() {
        this.cnx = new ConexionPostgresql();
    }
    
    public String verificarLogin(String user,String pass) throws SQLException {
        String rol = null;
        PreparedStatement statement = cnx.getCnx().prepareStatement("select usuario, rol, password from usuario");
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            if(result.getString("usuario").equals(user) && 
                    result.getString("password").equals(pass)) {
                rol = result.getString("rol");
                return rol;
            }
        }
        return rol;
    }
}

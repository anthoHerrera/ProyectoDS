/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony777
 */
public class ConexionPostgresql {
    Connection cnx;

    public ConexionPostgresql() {
        try {
<<<<<<< HEAD
            cnx = DriverManager.getConnection("jdbc:postgresql://localhost:5433/lineablancasa",
                     "postgres", "gabriel22samanes2");
=======
            cnx = DriverManager.getConnection("jdbc:postgresql://localhost/lineablancasa",
                     "postgres", "root");
>>>>>>> 39add9db1b3c32fb2c8f5d797766b79bbdbad88c
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPostgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

}

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
            cnx = DriverManager.getConnection("jdbc:postgresql://localhost:1234/lineablancasa",
                     "postgres", "889juanjo");
=======
            cnx = DriverManager.getConnection("jdbc:postgresql://localhost/lineablancasa",
                    "postgres", "root");
           
>>>>>>> 48c5fa9bac48b3e52481a5017aee4f601f3a973e
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPostgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }

}

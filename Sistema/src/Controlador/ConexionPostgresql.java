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
            cnx = DriverManager.getConnection("jdbc:postgresql://localhost:1234/lineablancasa"
					,"postgres","889juanjo");
=======
            cnx = DriverManager.getConnection("jdbc:postgresql://localhost:5433/lineablancasa"
					,"postgres","gabriel22samanes2");
>>>>>>> a38dcffb4d86977b41274ebe6ba81e0441c21bd8
            System.out.println("conectado");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPostgresql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Rarticulo;
import Modelo.Transaccion;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anthony777
 */
public class ControllerGerente2Test {
    
    public ControllerGerente2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultaClientes method, of class ControllerGerente.
     */
    @Test
    public void testConsultaClientes() throws Exception {
        System.out.println("consultaClientes");
        ControllerGerente instance = new ControllerGerente();
        ObservableList<Cliente> expResult = instance.consultaClientes();
        ObservableList<Cliente> result = instance.consultaClientes();
        assertNotEquals(expResult, result);
        
    }

    /**
     * Test of consultaVentas method, of class ControllerGerente.
     */
    @Test
    public void testConsultaVentas() throws Exception {
        System.out.println("consultaVentas");
        ControllerGerente instance = new ControllerGerente();
        ObservableList<Transaccion> expResult = instance.consultaVentas();
        ObservableList<Transaccion> result = instance.consultaVentas();
        assertNotEquals(expResult, result);
        
    }

    /**
     * Test of consultaNArticulos method, of class ControllerGerente.
     */
    @Test
    public void testConsultaNArticulos() throws Exception {
        System.out.println("consultaNArticulos");
        ControllerGerente instance = new ControllerGerente();
        ObservableList<Rarticulo> expResult = instance.consultaNArticulos();
        ObservableList<Rarticulo> result = instance.consultaNArticulos();
        assertNotEquals(expResult, result);
        
    }
    
}

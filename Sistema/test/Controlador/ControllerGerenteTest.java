/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
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
public class ControllerGerenteTest {
    
    public ControllerGerenteTest() {
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
     * Test of consultaVentasXMes method, of class ControllerGerente.
     */
    @Test
    public void testConsultaVentasXMes() throws Exception {
        System.out.println("consultaVentasXMes");
        String comando = "select * from transaccion where fecha >= '2018-10-01' "
                            + "and fecha <= '2018-10-31' and tipo = 'venta'";
        ControllerGerente instance = new ControllerGerente();
        ObservableList<Transaccion> expResult = instance.consultaVentasXMes(comando);
        ObservableList<Transaccion> result = instance.consultaVentasXMes(comando);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of consultaClientesXMes method, of class ControllerGerente.
     */
    @Test
    public void testConsultaClientesXMes() throws Exception {
        System.out.println("consultaClientesXMes");
        String comando = "select c.cedula, c.nombre, c.telefono, c.isVisible "
                            + "from cliente c, transaccion t where c.cedula = t.idCliente and "
                            + "t.fecha >= '2018-02-01' and t.fecha <= '2018-02-28'";
        ControllerGerente instance = new ControllerGerente();
        ObservableList<Cliente> expResult = instance.consultaClientesXMes(comando);
        ObservableList<Cliente> result = instance.consultaClientesXMes(comando);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

	/**
	 * Test of consultaClientes method, of class ControllerGerente.
	 */
	@Test
	public void testConsultaClientes() throws Exception {
		System.out.println("consultaClientes");
		ControllerGerente instance = new ControllerGerente();
		ObservableList<Cliente> expResult = null;
		ObservableList<Cliente> result = instance.consultaClientes();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of consultaVentas method, of class ControllerGerente.
	 */
	@Test
	public void testConsultaVentas() throws Exception {
		System.out.println("consultaVentas");
		ControllerGerente instance = new ControllerGerente();
		ObservableList<Transaccion> expResult = null;
		ObservableList<Transaccion> result = instance.consultaVentas();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of consultaNArticulos method, of class ControllerGerente.
	 */
	@Test
	public void testConsultaNArticulos() throws Exception {
		System.out.println("consultaNArticulos");
		ControllerGerente instance = new ControllerGerente();
		ObservableList<Rarticulo> expResult = null;
		ObservableList<Rarticulo> result = instance.consultaNArticulos();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
    
}

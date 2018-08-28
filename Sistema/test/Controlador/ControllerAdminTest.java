/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FactoryMethod.Articulo;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabpa
 */
public class ControllerAdminTest {
	
	public ControllerAdminTest() {
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
	 * Test of consultaArticulos method, of class ControllerAdmin.
	 */
	@Test
	public void testConsultaArticulos() throws Exception {
		System.out.println("consultaArticulos");
		String comando = "select * from articulo";
		ControllerAdmin instance = new ControllerAdmin();
		ArrayList<Articulo> expResult = null;
		ArrayList<Articulo> result = instance.consultaArticulos(comando);
		assertNotEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		
	}


	/**
	 * Test of cuentaArticulos method, of class ControllerAdmin.
	 */
	@Test
	public void testCuentaArticulos() throws Exception {
		System.out.println("cuentaArticulos");
		String comando = "select count(idarticulo) as count from articulo";
		ControllerAdmin instance = new ControllerAdmin();
		
		String result = instance.cuentaArticulos(comando);
		assertNotNull(result);
		// TODO review the generated test code and remove the default call to fail.
	}

	
}

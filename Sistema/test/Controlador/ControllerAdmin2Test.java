/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FactoryMethod.Articulo;
import java.util.ArrayList;
import java.util.List;
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
public class ControllerAdmin2Test {
	
	public ControllerAdmin2Test() {
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

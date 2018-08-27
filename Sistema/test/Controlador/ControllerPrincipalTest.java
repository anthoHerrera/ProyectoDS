/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
public class ControllerPrincipalTest {
	
	public ControllerPrincipalTest() {
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
	 * Test of verificarLogin method, of class ControllerPrincipal.
	 */
	@Test
	public void testVerificarLogin() throws Exception {
		System.out.println("verificarLogin");
		String user = "gdp@lineablancasa.com";
		String pass = "crack";
		ControllerPrincipal instance = new ControllerPrincipal();
		//String expResult = "";
		String result = instance.verificarLogin(user, pass);
		assertNotNull( result);
		// TODO review the generated test code and remove the default call to fail.
		
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy.pago;

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
public class TarjetaVISATest {
	
	public TarjetaVISATest() {
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
	 * Test of validateCredentials method, of class TarjetaVISA.
	 */
	@Test
	public void testValidateCredentials() {
		System.out.println("validateCredentials");
		String numeroTarjeta = "4546645726587895";
		TarjetaVISA instance = new TarjetaVISA();
		boolean result = instance.validateCredentials(numeroTarjeta);
		assertTrue(result);
		// TODO review the generated test code and remove the default call to fail.
	}

}

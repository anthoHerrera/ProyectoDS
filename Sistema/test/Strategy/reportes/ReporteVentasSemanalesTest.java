/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy.reportes;

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
public class ReporteVentasSemanalesTest {
	
	public ReporteVentasSemanalesTest() {
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
	 * Test of ejecutarQuery method, of class ReporteVentasSemanales.
	 */
	
	@Test
	public void testEjecutarQuery(){
		ReporteVentasSemanales instance = new ReporteVentasSemanales();
		assertNotNull(instance.getReportes());
		
	}
}

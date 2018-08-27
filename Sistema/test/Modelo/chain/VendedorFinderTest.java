/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.chain;

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
public class VendedorFinderTest {
    
    public VendedorFinderTest() {
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
     * Test of checkFree method, of class VendedorFinder.
     */
    @Test
    public void testCheckFree() {
        System.out.println("checkFree");
        VendedorFinder instance = new VendedorFinder(new Vendedor("Anthony", "0901587410"));
        assertTrue(instance.isFree());
        
        
    }
    
}

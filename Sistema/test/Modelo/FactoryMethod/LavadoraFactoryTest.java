/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.FactoryMethod;

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
public class LavadoraFactoryTest {
    
    public LavadoraFactoryTest() {
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
     * Test of createLavadora method, of class LavadoraFactory.
     */
    @Test
    public void testCreateLavadora() {
        System.out.println("createLavadora");
        String idArticulo = "la2";
        String nombre = "lavadora prueba";
        String descripcion = "sistema aquasaver";
        String marca = "mabe";
        double precio = 100.0;
        int capacidad = 4;
        int nivelesTemperatura = 2;
        LavadoraFactory instance = new LavadoraFactory();
        Lavadora expResult = null;
        Lavadora result = instance.createLavadora(idArticulo, nombre, descripcion, marca, precio, capacidad, nivelesTemperatura);
        assertNotSame(expResult, result);
        
    }
    
}

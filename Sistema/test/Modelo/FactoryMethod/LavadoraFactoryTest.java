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
        String idArticulo1 = "la1";
        String nombre = "lavadora prueba";
        String nombre1 = "lavadora prueba2";
        String descripcion = "sistema aquasaver";
        String descripcion1 = "sistema aquasaver";
        String marca = "mabe";
        String marca1 = "mabe";
        double precio = 100.0;
        double precio1 = 100.0;
        int capacidad = 4;
        int capacidad1 = 5;
        int nivelesTemperatura = 2;
        int nivelesTemperatura1 = 1;
        LavadoraFactory instance = new LavadoraFactory();
        Lavadora expResult = instance.createLavadora(idArticulo1, nombre1, descripcion1, marca1, precio1, capacidad1, nivelesTemperatura1);
        Lavadora result = instance.createLavadora(idArticulo, nombre, descripcion, marca, precio, capacidad, nivelesTemperatura);
        assertNotSame(expResult, result);
        
    }
    
}

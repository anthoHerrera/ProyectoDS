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
 * @author USER
 */
public class RefrigeradoraFactoryTest {
    
    public RefrigeradoraFactoryTest() {
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
     * Test of createRefrigeradora method, of class RefrigeradoraFactory.
     */
    @Test
    public void testCreateRefrigeradora() {
        System.out.println("createRefrigeradora");
        String idArticulo = "re1";
        String nombre = "refrigeradora";
        String descripcion = "";
        String marca = "Durex";
        double precio = 200;
        int cantidadPuertas = 2;
        int capacidad = 100;
        String filtroAgua = "si";
        String idArticulo1 = "re2";
        String nombre1 = "refrigeradora";
        String descripcion1 = "";
        String marca1 = "Durex";
        double precio1 = 200;
        int cantidadPuertas1 = 2;
        int capacidad1 = 100;
        String filtroAgua1 = "si";
        RefrigeradoraFactory instance = new RefrigeradoraFactory();
        Refrigeradora expResult = instance.createRefrigeradora(idArticulo1, nombre1, descripcion1, marca1, precio1, cantidadPuertas1, capacidad1, filtroAgua1);
        Refrigeradora result = instance.createRefrigeradora(idArticulo, nombre, descripcion, marca, precio, cantidadPuertas, capacidad, filtroAgua);
        assertNotSame(expResult, result);
        
    }
    
}

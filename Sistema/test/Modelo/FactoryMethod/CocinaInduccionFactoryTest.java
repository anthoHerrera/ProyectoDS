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
public class CocinaInduccionFactoryTest {
    
    public CocinaInduccionFactoryTest() {
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
     * Test of createCocina method, of class CocinaInduccionFactory.
     */
    @Test
    public void testCreateCocina() {
        System.out.println("createCocina");
        String idArticulo = "co1";
        String nombre = "cocina andalucia";
        String descripcion = "una cocina de induccion";
        String marca = "indurama";
        double precio = 500;
        String tamano = "100";
        String potenciaTotal = "1000 watts";
        int inductores = 4;
        String voltaje = "220v";
        String idArticulo1 = "co2";
        String nombre1 = "cocina andalucia";
        String descripcion1 = "una cocina de induccion";
        String marca1 = "indurama";
        double precio1 = 500;
        String tamano1 = "100";
        String potenciaTotal1 = "1000 watts";
        int inductores1 = 4;
        String voltaje1 = "220v";
        CocinaInduccionFactory instance = new CocinaInduccionFactory();
        CocinaInduccion expResult = instance.createCocina(idArticulo1, nombre1, descripcion1, marca1, precio1, tamano1, potenciaTotal1, inductores1, voltaje1);
        CocinaInduccion result = instance.createCocina(idArticulo, nombre, descripcion, marca, precio, tamano, potenciaTotal, inductores, voltaje);
        assertNotSame(expResult, result);
        
    }
    
}

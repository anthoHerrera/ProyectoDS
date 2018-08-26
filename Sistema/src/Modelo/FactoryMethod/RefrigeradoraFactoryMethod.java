/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.FactoryMethod;

/**
 *
 * @author Anthony777
 */
public interface RefrigeradoraFactoryMethod {
    public Refrigeradora createRefrigeradora(String idArticulo, String nombre, String descripcion, 
            String marca, double precio, int cantidadPuertas, int capacidad, String filtroAgua);
}

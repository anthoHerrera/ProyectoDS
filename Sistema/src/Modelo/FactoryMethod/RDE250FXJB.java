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
public class RDE250FXJB extends Refrigeradora {
    
    public RDE250FXJB(String idArticulo, String nombre, String descripcion, String marca, 
            double precio, int cantidadPuertas, int capacidad, String filtroAgua) {
        super(idArticulo, nombre, descripcion, marca, precio, cantidadPuertas, capacidad, filtroAgua);
    }
    
}

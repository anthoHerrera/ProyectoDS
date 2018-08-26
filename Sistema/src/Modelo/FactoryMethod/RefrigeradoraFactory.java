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
public class RefrigeradoraFactory implements RefrigeradoraFactoryMethod {

    @Override
    public Refrigeradora createRefrigeradora(String nombre, String descripcion, 
            String marca, double precio, int cantidadPuertas, int capacidad, String filtroAgua) {
        if(nombre.equals("Refrigeradora RDE235UWAB")) {
            return new RDE235UWAB(nombre, descripcion, marca, precio, cantidadPuertas, 
                    capacidad, filtroAgua);
        }else {
            return new RDE250FXJB(nombre, descripcion, marca, precio, cantidadPuertas, 
                    capacidad, filtroAgua);
        }
    }
    
}

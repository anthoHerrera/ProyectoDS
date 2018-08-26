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
    public Refrigeradora createRefrigeradora(String idArticulo, String nombre, String descripcion, 
            String marca, double precio, int cantidadPuertas, int capacidad, String filtroAgua) {
        if(idArticulo.equals("re1")) {
            return new RDE235UWAB(idArticulo, nombre, descripcion, marca, precio, 
                    cantidadPuertas, capacidad, filtroAgua);
        }else {
            return new RDE250FXJB(idArticulo, nombre, descripcion, marca, precio, 
                    cantidadPuertas, capacidad, filtroAgua);
        }
    }
    
}

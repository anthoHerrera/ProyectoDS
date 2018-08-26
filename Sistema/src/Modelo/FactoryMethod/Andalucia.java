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
public class Andalucia extends CocinaInduccion {
    
    public Andalucia(String idArticulo, String nombre, String descripcion, String marca, double precio, String tamano, String potenciaTotal, int inductores, String voltaje) {
        super(idArticulo, nombre, descripcion, marca, precio, tamano, potenciaTotal, inductores, voltaje);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

import Modelo.CocinaInduccion;

/**
 *
 * @author JuanJose FS
 */
public class Andalucia extends CocinaInduccion{

    public Andalucia(String nombre, String descripcion, String marca, int precio, String tamano, String potenciaTotal, int inductores, String voltaje) {
        super(nombre, descripcion, marca, precio, tamano, potenciaTotal, inductores, voltaje);
    }

    
    
}
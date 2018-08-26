/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

import Modelo.Refrigeradora;

/**
 *
 * @author JuanJose FS
 */
public interface RefrigeradoraFactoryMethod {
    Refrigeradora createRefrigeradora(String nombre, String descripcion, String marca, int precio, int cantidadPuertas, String capacidad, String filtroAgua);

}

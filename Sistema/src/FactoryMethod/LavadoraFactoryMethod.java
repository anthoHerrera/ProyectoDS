/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

import Modelo.Lavadora;

/**
 *
 * @author JuanJose FS
 */
public interface LavadoraFactoryMethod {
    Lavadora createLavadora(String nombre, String descripcion, String marca, int precio, String capacidad, int nivelesTemperatura);

}

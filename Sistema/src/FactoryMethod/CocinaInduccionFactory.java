/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

import Modelo.Articulo;
import Modelo.CocinaInduccion;

/**
 *
 * @author JuanJose FS
 */
public class CocinaInduccionFactory implements CocinaFactoryMethod {
    
    @Override
    public CocinaInduccion createCocina(String nombre, String descripcion, String marca, int precio, String tamano, String potencia, int inductores, String voltaje) {
        
    }
   
   
}

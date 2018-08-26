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
public class CocinaInduccionFactory implements CocinaFactoryMethod {

    @Override
    public CocinaInduccion createCocina(String nombre, String descripcion, String marca, 
            double precio, String tamano, String potenciaTotal, int inductores, String voltaje) {
        if(nombre.equals("Cocina de induccion Andalucia")) {
            return new Andalucia(nombre, descripcion, marca, precio, tamano, potenciaTotal, 
                    inductores, voltaje);
        }else {
            return new Ginebra(nombre, descripcion, marca, precio, tamano, potenciaTotal, 
                    inductores, voltaje);
        }
    }
    
}

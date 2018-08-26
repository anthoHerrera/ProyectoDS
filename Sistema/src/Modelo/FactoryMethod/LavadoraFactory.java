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
public class LavadoraFactory implements LavadoraFactoryMethod {

    @Override
    public Lavadora createLavadora(String idArticulo, String nombre, String descripcion, String marca, 
            double precio, int capacidad, int nivelesTemperatura) {
        if(idArticulo.equals("la1")) {
            return new LMD75B0(idArticulo, nombre, descripcion, marca, precio, 
                    capacidad, nivelesTemperatura);
        }else if(idArticulo.equals("la2")) {
            return new LMA70200WGAB0(idArticulo, nombre, descripcion, marca, precio, 
                    capacidad, nivelesTemperatura);
        }else {
            return new WMC1786SXWW3(idArticulo, nombre, descripcion, marca, precio, 
                    capacidad, nivelesTemperatura);
        }
        
    }
    
}

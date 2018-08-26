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
    public Lavadora createLavadora(String nombre, String descripcion, String marca, 
            double precio, int capacidad, int nivelesTemperatura) {
        if(nombre.equals("Lavadora LMD75B0")) {
            return new LMD75B0(nombre, descripcion, marca, precio, capacidad, nivelesTemperatura);
        }else if(nombre.equals("Lavadora LMA70200WGAB0")) {
            return new LMA70200WGAB0(nombre, descripcion, marca, precio, capacidad, nivelesTemperatura);
        }else {
            return new WMC1786SXWW3(nombre, descripcion, marca, precio, capacidad, nivelesTemperatura);
        }
        
    }
    
}

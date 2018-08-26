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
public abstract class RefrigeradoraFactory {
    protected Refrigeradora fridge;
    
    public void crearRefrigeradora(){
        fridge = new Refrigeradora();
    }

    public Refrigeradora getRefrigeradora() {
        return fridge;
    }
    public abstract void buildModel();
    
    public abstract void buildPuertas();
    
    public abstract void buildFiltros();
}

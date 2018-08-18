/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

import Modelo.Refrigeradora;

/**
 *
 * @author JuanJose FS
 */
public class DirectorRefrigeradora {
    private RefrigeradoraBuilder fridgeBuilder;
    
    public void construirRefrigeradora(){
        fridgeBuilder.crearRefrigeradora();
        fridgeBuilder.buildModel();
        fridgeBuilder.buildFiltros();
        fridgeBuilder.buildPuertas();
    }
   
    public void setRefrigeradoraBuilder(RefrigeradoraBuilder cons) {
        fridgeBuilder = cons;
    }

    public Refrigeradora getRefrigeradora() {
        return this.fridgeBuilder.getRefrigeradora();
    }
}

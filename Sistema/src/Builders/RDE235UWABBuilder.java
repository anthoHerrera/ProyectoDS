/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

/**
 *
 * @author JuanJose FS
 */
public class RDE235UWABBuilder extends RefrigeradoraBuilder{

    @Override
    public void buildModel() {
        fridge.setNombre("Refrigeradora RDE235UWAB");
        fridge.setMarca("Mabe");
        fridge.setDescripcion("Refrigeradora ultima gama");
    }

    @Override
    public void buildPuertas() {
        fridge.setCantidadPuertas(2);
        fridge.setCapacidad(25);
    }

    @Override
    public void buildFiltros() {
        fridge.setFiltroAgua("Con filtro");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

/**
 *
 * @author JuanJose FS
 */
public class RDE250FXJB extends RefrigeradoraFactory{

    @Override
    public void buildModel() {
        fridge.setNombre("Refrigeradora RDE250FXJB");
        fridge.setMarca("Whirpool");
        fridge.setDescripcion("Refrigeradora ultima generacion");
    }

    @Override
    public void buildPuertas() {
        fridge.setCantidadPuertas(2);
        fridge.setCapacidad(20);
        fridge.setPrecio(1500);
    }

    @Override
    public void buildFiltros() {
        fridge.setFiltroAgua("Filtro extra");
    }
    
    
}

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
public class RDE250FXJBBuilder extends RefrigeradoraBuilder{

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
    }

    @Override
    public void buildFiltros() {
        fridge.setFiltroAgua("Filtro extra");
    }
    
    
}

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
public class GinebraBuilder extends CocinaInduccionBuilder{

     @Override
    public void buildModel() {
        cocina.setNombre("Cocina de induccion Ginebra");
        cocina.setMarca("Whirpool");
        cocina.setDescripcion("Cocina de induccion ahorradora");
    }

    @Override
    public void buildInductores() {
        cocina.setInductores(3);
        cocina.setTamano("8 pulgadas");
    }

    @Override
    public void buildParteElectrica() {
        cocina.setVoltaje("100 volteos");
        cocina.setPotenciaTotal("1000 Wt");
    }
    
}

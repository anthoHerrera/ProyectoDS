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
public class AndaluciaBuilder extends CocinaInduccionBuilder{

    @Override
    public void buildModel() {
        cocina.setNombre("Cocina de induccion Andalucia");
        cocina.setMarca("Mabe");
        cocina.setDescripcion("Cocina de induccion ultimo modelo");
    }

    @Override
    public void buildInductores() {
        cocina.setInductores(2);
        cocina.setTamano("10 pulgadas");
    }

    @Override
    public void buildParteElectrica() {
        cocina.setVoltaje("80 volteos");
        cocina.setPotenciaTotal("1000 Wt");
    }
    
}

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
        cocina.setMarca("Indurama");
        cocina.setDescripcion("Alto: 94 cm Ancho: 80 cm Profundidad: 58 cm");
    }

    @Override
    public void buildInductores() {
        cocina.setInductores(4);
        cocina.setTamano("mediana");
        cocina.setPrecio(850);
    }

    @Override
    public void buildParteElectrica() {
        cocina.setVoltaje("220 v");
        cocina.setPotenciaTotal("9246 watts");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

import Modelo.CocinaInduccion;

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
        ((CocinaInduccion)cocina).setInductores(4);
        ((CocinaInduccion)cocina).setTamano("mediana");
        cocina.setPrecio(850);
    }

    @Override
    public void buildParteElectrica() {
        ((CocinaInduccion)cocina).setVoltaje("220 v");
        ((CocinaInduccion)cocina).setPotenciaTotal("9246 watts");
    }
    
}

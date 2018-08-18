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
public class AndaluciaBuilder extends CocinaInduccionBuilder{

    @Override
    public void buildModel() {
        cocina.setNombre("Cocina de induccion Andalucia");
        cocina.setMarca("Indurama");
        cocina.setDescripcion("Alto 94cm Ancho 60cm Profundidad 58cm");
    }

    @Override
    public void buildInductores() {
        cocina.setInductores(4);
        cocina.setTamano("mediana");
        cocina.setPrecio(574);
    }

    @Override
    public void buildParteElectrica() {
        cocina.setVoltaje("220 v");
        cocina.setPotenciaTotal("8240 watts");
    }
    
}

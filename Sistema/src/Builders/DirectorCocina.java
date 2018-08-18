/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

import Modelo.ArticuloLineaBlanca;
import Modelo.CocinaInduccion;

/**
 *
 * @author JuanJose FS
 */
public class DirectorCocina {

    private CocinaInduccionBuilder cocinaBuilder;

    public void construirCocina() {
        cocinaBuilder.crearCocinaInduccion();
        cocinaBuilder.buildModel();
        cocinaBuilder.buildParteElectrica();
        cocinaBuilder.buildInductores();
    }

    public void setCocinaInduccionBuilder(CocinaInduccionBuilder cons) {
        cocinaBuilder = cons;
    }

    public CocinaInduccion getCocina() {
        return this.cocinaBuilder.getCocina();
    }

}

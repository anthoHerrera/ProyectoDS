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
public abstract class CocinaInduccionBuilder {
    protected CocinaInduccion cocina;
    
    public void crearCocinaInduccion(){
        cocina = new CocinaInduccion();
    }

    public CocinaInduccion getCocina() {
        return cocina;
    }
   
    public abstract void buildModel();
        
    public abstract void buildInductores();
    
    public abstract void buildParteElectrica();
}

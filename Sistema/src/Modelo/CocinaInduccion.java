/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JuanJose FS
 */
public class CocinaInduccion extends ArticuloLineaBlanca{
    private String tamano;
    private String potenciaTotal;
    private int inductores;
    private String voltaje;

	public CocinaInduccion(){
		
	}
    /*public CocinaInduccion(String nombre, String marca) {
        super(nombre, marca);
    }*/

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getPotenciaTotal() {
        return potenciaTotal;
    }

    public void setPotenciaTotal(String potenciaTotal) {
        this.potenciaTotal = potenciaTotal;
    }

    public int getInductores() {
        return inductores;
    }

    public void setInductores(int inductores) {
        this.inductores = inductores;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }
    
    

}

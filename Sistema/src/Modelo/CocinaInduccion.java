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
public class CocinaInduccion extends Articulo{
    protected String tamano;
    protected String potenciaTotal;
    protected int inductores;
    protected String voltaje;

    public CocinaInduccion(String nombre, String descripcion, String  marca, int precio, String tamano, String potenciaTotal, int inductores, String voltaje ) {
        super(nombre, descripcion, marca, precio);
        this.tamano = tamano;
        this.potenciaTotal = potenciaTotal;
        this.inductores = inductores;
        this.voltaje = voltaje;
    }

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

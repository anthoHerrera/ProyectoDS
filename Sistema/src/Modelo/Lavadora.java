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
public class Lavadora extends ArticuloLineaBlanca{
    private int capacidad;
    private int nivelesTemperatura;


    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNivelesTemperatura() {
        return nivelesTemperatura;
    }

    public void setNivelesTemperatura(int nivelesTemperatura) {
        this.nivelesTemperatura = nivelesTemperatura;
    }
    
}

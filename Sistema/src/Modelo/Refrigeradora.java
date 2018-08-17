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
public class Refrigeradora extends ArticuloLineaBlanca{
    private int cantidadPuertas;
    private int capacidad;
    private String filtroAgua;
    
    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getFiltroAgua() {
        return filtroAgua;
    }

    public void setFiltroAgua(String filtroAgua) {
        this.filtroAgua = filtroAgua;
    }
    
}

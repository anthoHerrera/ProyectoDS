/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.FactoryMethod;


/**
 *
 * @author JuanJose FS
 */
public class Refrigeradora extends Articulo {

    private int cantidadPuertas;
    private int capacidad;
    private String filtroAgua;

    public Refrigeradora(String idArticulo, String nombre, String descripcion, String marca, double precio, int cantidadPuertas, int capacidad, String filtroAgua) {
        super(idArticulo, nombre, descripcion, marca, precio);
        this.cantidadPuertas = cantidadPuertas;
        this.capacidad = capacidad;
        this.filtroAgua = filtroAgua;
    }

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

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
public class ArticuloGenerico extends Articulo{
    private String tamano;
    private String potenciaTotal;
    private int inductores;
    private String voltaje;
    private int cantidadPuertas;
    private int capacidad;
    private String filtroAgua;
    private int nivelesTemperatura;

    public ArticuloGenerico(String idArticulo, String nombre, String descripcion, String marca, double precio,String tamano, String potenciaTotal, int inductores, String voltaje, int cantidadPuertas, int capacidad, String filtroAgua, int nivelesTemperatura) {
        super(idArticulo, nombre, descripcion, marca, precio);
        this.tamano = tamano;
        this.potenciaTotal = potenciaTotal;
        this.inductores = inductores;
        this.voltaje = voltaje;
        this.cantidadPuertas = cantidadPuertas;
        this.capacidad = capacidad;
        this.filtroAgua = filtroAgua;
        this.nivelesTemperatura = nivelesTemperatura;
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

    public int getNivelesTemperatura() {
        return nivelesTemperatura;
    }

    public void setNivelesTemperatura(int nivelesTemperatura) {
        this.nivelesTemperatura = nivelesTemperatura;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
   
    
}

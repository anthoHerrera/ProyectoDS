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
public abstract class Articulo {
    protected String nombre;
    protected String descripcion;
    protected String marca;
    protected int precio;

    public Articulo(String nombre, String descripcion, String marca, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
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

    public int getPrecio() {
		return precio;
	}

    public void setPrecio(int precio) {
		this.precio = precio;
	}
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Anthony777
 */
public class Cliente {
    private Cedula cedula;
    private String nombre, telefono;
    private boolean isVisible;

    public Cliente(Cedula cedula, String nombre, String telefono, boolean isVisible) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.isVisible = isVisible;
    }

    public String getCedula() {
        return cedula.getCedula();
    }

    public void setCedula(String cedula) {
        this.cedula = new Cedula(cedula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
}

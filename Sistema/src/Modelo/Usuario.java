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
public class Usuario {
    private Cedula cedula;
    private String usuario;
    private String clave;

    public Usuario(Cedula cedula, String usuario, String clave) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getCedula() {
        return cedula.getCedula();
    }

    public void setCedula(String cedula) {
        this.cedula = new Cedula(cedula);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}

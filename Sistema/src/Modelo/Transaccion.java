/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Anthony777
 */
public class Transaccion {
    private int idTransaccion;
    private String tipo;
    private Date fecha;
    private String idEmpleado;
    private String idCliente;
    private boolean isVisible;

    public Transaccion(int idTransaccion, String tipo, Date fecha, String idEmpleado, 
            String idCliente, boolean isVisible) {
        this.idTransaccion = idTransaccion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        this.isVisible = isVisible;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
}

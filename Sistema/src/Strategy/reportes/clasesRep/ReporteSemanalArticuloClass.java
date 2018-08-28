/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy.reportes.clasesRep;

/**
 *
 * @author Anthony777
 */
public class ReporteSemanalArticuloClass {
    private String idArticulo;
    private String nombre;
    private Integer cantidadVentas;
    private float totalVendido;

    public ReporteSemanalArticuloClass(String idArticulo, String nombre, Integer cantidadVentas, float totalVendido) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.cantidadVentas = cantidadVentas;
        this.totalVendido = totalVendido;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idrticulo) {
        this.idArticulo = idrticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(Integer cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public float getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(float totalVendido) {
        this.totalVendido = totalVendido;
    }
    
    
}

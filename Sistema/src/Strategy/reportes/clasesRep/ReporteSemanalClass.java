
package Strategy.reportes.clasesRep;

/**
 *
 * @author gabpa
 */
public class ReporteSemanalClass {
	
	private String idEmpleado;
	private Integer cantidadVentas;
	private float totalVendido;

	public ReporteSemanalClass(String idEmpleado, Integer cantidadVentas, float totalVendido) {
		this.idEmpleado = idEmpleado;
		this.cantidadVentas = cantidadVentas;
		this.totalVendido = totalVendido;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
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

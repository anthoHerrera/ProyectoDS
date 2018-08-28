
package Strategy.pago;

/**
 *
 * @author gabpa
 */
public class TarjetaVISA extends TarjetaCredito{

	
	@Override
	boolean validateCredentials(String numeroTarjeta) {
		boolean isNumeric = numeroTarjeta.matches("-?\\d+(\\.\\d+)?");
		return numeroTarjeta.length() == 16 && isNumeric;
	}

	@Override
	void confirmPayment() {
		System.out.println("Pago Realizado con exito.");
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy.pago;

/**
 *
 * @author gabpa
 */
public abstract class TarjetaCredito implements TipoDePago{

	protected String numeroTarjeta;
	protected String cliente;
	protected String fechaExp;
	
	@Override
	public void pagar() {
		
	}
	
	abstract boolean validateCredentials(String numeroTarjeta);
	abstract void confirmPayment();
	
	
}

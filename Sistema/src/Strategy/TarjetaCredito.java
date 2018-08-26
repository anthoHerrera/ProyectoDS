/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

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
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	abstract void validateCredentials();
	abstract void confirmPayment();
	
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

/**
 *
 * @author gabpa
 */

public class LMD75B0 extends LavadoraFactory{
	
	@Override
	public void construirNucleo() {
		lavadora.setCapacidad(17);
		lavadora.setNivelesTemperatura(1);
	}

	@Override
	public void construirModelo() {
		lavadora.setNombre("LavadoraLMD75B0");
		lavadora.setMarca("Mabe");
		lavadora.setPrecio(400);
	}

	@Override
	public void construirDescripcion() {
		lavadora.setDescripcion("SemiAutomática, Sistema de Lavado a propela");
	}
	
}

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
public class WMC1786SXWW3 extends LavadoraFactory{
	
	@Override
	public void construirNucleo() {
		lavadora.setCapacidad(17);
		lavadora.setNivelesTemperatura(5);
	}

	@Override
	public void construirModelo() {
		lavadora.setNombre("LavadoraWMC1786SXWW3");
		lavadora.setMarca("Mabe");
		lavadora.setPrecio(350);
	}

	@Override
	public void construirDescripcion() {
		lavadora.setDescripcion("Carga Frontal, Ciclo steam assist");
	}
	
}

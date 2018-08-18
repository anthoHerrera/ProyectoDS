/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

/**
 *
 * @author gabpa
 */
public class LavadoraLMA70200WGAB0Builder extends LavadoraBuilder{

	@Override
	public void construirNucleo() {
		lavadora.setCapacidad(20);
		lavadora.setNivelesTemperatura(3);
	}

	@Override
	public void construirModelo() {
		lavadora.setNombre("LavadoraLMA70200WGAB0");
		lavadora.setMarca("Mabe");
		lavadora.setPrecio(600);
	}

	@Override
	public void construirDescripcion() {
		lavadora.setDescripcion("Automática, Tecnología Aqua Saver");
	}
	
	
	
	
	
}

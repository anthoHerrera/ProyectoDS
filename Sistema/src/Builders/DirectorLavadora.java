/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builders;

import Modelo.Lavadora;

/**
 *
 * @author gabpa
 */
public class DirectorLavadora {
	
	private LavadoraBuilder constructor;
	
	public void construirLavadora(){
		constructor.crearLavadora();
		constructor.construirModelo();
		constructor.construirDescripcion();
		constructor.construirNucleo();
		
	}
	
	public void setConstructorLavadoras(LavadoraBuilder cons){
		this.constructor = cons;
	}
	
	public Lavadora getLavadora(){
		return this.constructor.getLavadora();
	}
}

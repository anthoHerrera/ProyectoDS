/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author gabpa
 */
public abstract class ConstructorLavadoras {
	
	protected Lavadora lavadora;
	
	public void crearLavadora(){
		lavadora = new Lavadora();
	}
	
	public Lavadora getLavadora(){
		return lavadora;
	}
	
	public abstract void construirModelo();
	public abstract void construirNucleo();
	public abstract void construirDescripcion();
	
	
	
}

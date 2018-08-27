/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.chain;

/**
 *
 * @author User
 */
public class VendedorFinder extends VendedorProcessor{

    private boolean isFree = true;
    private Vendedor vendedor;

    public VendedorFinder(Vendedor vendedor) {
        super(vendedor);
    }

    
    public boolean isFree() {
        return isFree;
    }
    
    public void setFree(boolean free){
        this.isFree = free;
    }

    @Override
    public VendedorProcessor checkFree() {
        if(this.isFree) {
            this.isFree = false;
            return this;
        }
        return this.checkNext();
    }
    
    
    
}

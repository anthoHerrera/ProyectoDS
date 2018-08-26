/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.chain;

/**
 *
 * @author User
 */
public class VendedorFinder extends VendedorProcessor{

    private boolean isFree;
    private Vendedor vendedor;

    public VendedorFinder(Vendedor vendedor) {
        this.vendedor = vendedor;
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
            return this;
        }
        return this.checkNext();
    }
    
}

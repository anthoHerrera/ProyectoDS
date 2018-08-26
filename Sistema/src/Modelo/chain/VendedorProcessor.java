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
public abstract class VendedorProcessor {
    private VendedorProcessor nextProcessor;

    public void setNext(VendedorProcessor next){
        this.nextProcessor = next;
    }
    
    public abstract VendedorProcessor checkFree();
    
    protected VendedorProcessor checkNext(){
        if (this.nextProcessor == null) {
            return null;
        }
        return this.nextProcessor.checkFree();
    }
    
}

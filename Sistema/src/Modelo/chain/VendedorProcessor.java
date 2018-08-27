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
public abstract class VendedorProcessor {
    private VendedorProcessor nextProcessor = null;
    private Vendedor vendedor;

    public VendedorProcessor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    

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

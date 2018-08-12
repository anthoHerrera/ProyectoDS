/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author JuanJose FS
 */
public class PanelPrincipal {
    private Pane root;
    private VBox botones;
    private Button gerente,admin,superadmin,vendedor;
    
    public PanelPrincipal() {
        root= new Pane();
        setUp();
        
    }
    
    private void setUp(){
        gerente = new Button("Gerente");
        admin = new Button("Administrador");
        superadmin = new Button("SuperAdministrador");
        vendedor = new Button("Vendedor");
        botones = new VBox();
        botones.getChildren().addAll(gerente,admin,superadmin,vendedor);
        root.getChildren().add(botones);
        gerente.setOnAction(e-> new PanelGerente());
        admin.setOnAction(e-> new PanelAdmin());
        superadmin.setOnAction(e-> new PanelSuper());
        vendedor.setOnAction(e-> new PanelVendedor());
    }

    public Pane getRoot() {
        return root;
        
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    
}

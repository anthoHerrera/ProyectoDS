/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy.reportes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author gabpa
 */
public final class ReporteVentasSemanales implements Reporte{
	
	//VENTAS SEMANALES POR VENDEDOR
	//IdVendedor,Cantidad Ventas, Monto
	
	private final VBox root;
	private Stage stage;
	private Scene scene;
	private Button cerrar;
	private Label titulo;
	private TableView<> tabla;
	
	public ReporteVentasSemanales(){
		root = new VBox(20);
		
		setupPanes();
		generarReporte();
		setupStage();
	}
	
	
	private void setupPanes(){
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(10,10,10,10));
		
		
	}
	
	@Override
	public void generarReporte() {
		
	}
	
	private void setupStage(){
		
	}
	
	
	
	
}

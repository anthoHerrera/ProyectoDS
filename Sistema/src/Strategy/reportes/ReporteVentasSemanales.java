/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy.reportes;

import Controlador.ConexionPostgresql;
import Strategy.reportes.clasesRep.ReporteSemanalClass;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
	private TableView<ReporteSemanalClass> tabla;
	private ObservableList<ReporteSemanalClass> reportes;
	
	public ReporteVentasSemanales(){
		root = new VBox(20);
		
		generarReporte();
		setupPanes();
		setupStage();
	}
	
	
	private void setupPanes(){
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(10,10,10,10));
		
		titulo = new Label("REPORTE VENTAS POR EMPLEADO");
		titulo.setFont(new Font("Arial",24));
		
		cerrar = new Button("Cerrar");
		cerrar.setPrefSize(160, 80);
		cerrar.setOnAction(e->stage.close());
		
		root.setStyle("-fx-background-color: lavender");
		root.getChildren().addAll(titulo,tabla,cerrar);
	}
	
	@Override
	public void generarReporte(){
		
		reportes = this.ejecutarQuery();
		tabla = new TableView<>();
		
		if(reportes== null)
			showError();
			
		tabla.setItems(reportes);
		tabla.setEditable(false);
		
		
		TableColumn idEmpleado = new TableColumn("Empleado");
			idEmpleado.setMinWidth(150);
			idEmpleado.setCellValueFactory( new PropertyValueFactory<>("idEmpleado"));
			
		TableColumn nombreEmpleado = new TableColumn("Nombre");
			nombreEmpleado.setMinWidth(150);
			nombreEmpleado.setCellValueFactory( new PropertyValueFactory<>("nombre"));
			
		TableColumn NumTransacciones = new TableColumn("Cantidad Ventas");
                NumTransacciones.setMinWidth(150);
                NumTransacciones.setCellValueFactory( new PropertyValueFactory<>("cantidadVentas"));
				
		TableColumn TotalVendido = new TableColumn("Total Vendido");
			TotalVendido.setMinWidth(150);
			TotalVendido.setCellValueFactory( new PropertyValueFactory<>("totalVendido"));
			
		tabla.getColumns().addAll(idEmpleado,nombreEmpleado,NumTransacciones,TotalVendido);
		
	}
	
	private ObservableList<ReporteSemanalClass> ejecutarQuery() {
		ObservableList obs = null;
		ArrayList<ReporteSemanalClass> lista = new ArrayList<>();
		
		try {
			ConexionPostgresql conexion = new ConexionPostgresql();
			
			String query = "select us.nombre as nombre , t.idempleado as empl,count(t.idtransaccion) as cant, sum(sq2.suma) as suma \n"
						 + "from transaccion t, usuario us ,"
												 + "(select t.idtransaccion as transac, sum(a.precio) as suma \n"
												 + "from transaccion t \n"
												 + "join  articulostransaccion at on at.idtransaccion = t.idtransaccion \n"
												 + "join articulo a on a.idarticulo = at.idarticulo \n"
												 + "where t.tipo like ? \n group by transac) sq2 \n"
						+ "where t.idtransaccion = sq2.transac and us.usuario = t.idempleado\n"
						+ "group by empl,nombre";
			
			
			PreparedStatement statements = conexion.getCnx().
					prepareStatement(query);
			statements.setString(1, "venta");
			
			ResultSet result = statements.executeQuery();
			while(result.next()){
				String nombreEmpl = result.getString("nombre");
				String empleado = result.getString("empl");
				Integer numTransacciones = result.getInt("cant");
				float total = result.getFloat("suma");
				
				ReporteSemanalClass reporte = new ReporteSemanalClass(nombreEmpl,empleado,numTransacciones, total);
				lista.add(reporte);
			}
			
			obs = FXCollections.observableArrayList(lista);
			return obs;
			
		} catch (SQLException ex) {
			Logger.getLogger(ReporteVentasSemanales.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return obs;
	}
	
	private void setupStage(){
		stage = new Stage();
		scene = new Scene(this.root,600,400);
		stage.setScene(scene);
		stage.setTitle("Reporte Ventas");
		stage.showAndWait();
	}

    private void showError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Se ha producido un error");
        alert.setContentText("El sistema no ha podido mostrar el reporte");
        alert.showAndWait();
    }

    public ObservableList<ReporteSemanalClass> getReportes() {
        return reportes;
    }

}

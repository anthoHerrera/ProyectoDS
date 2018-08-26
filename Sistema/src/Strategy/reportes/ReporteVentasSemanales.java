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
public final class ReporteVentasSemanales implements Reporte {

    //VENTAS SEMANALES POR VENDEDOR
    //IdVendedor,Cantidad Ventas, Monto
    private final VBox root;
    private Stage stage;
    private Scene scene;
    private Button cerrar;
    private Label titulo;
    private TableView<ReporteSemanalClass> tabla;
    private ObservableList<ReporteSemanalClass> reportes;

    public ReporteVentasSemanales() {
        root = new VBox(20);

        setupPanes();
        generarReporte();
        setupStage();
    }

    private void setupPanes() {
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));

        titulo = new Label("REPORTE VENTAS POR EMPLEADO");
        titulo.setFont(new Font("Arial", 24));

        reportes = this.ejecutarQuery();
        tabla = new TableView<>();

        if (reportes == null) {
            showError();
        }

        tabla.setItems(reportes);
        tabla.setEditable(false);

        TableColumn idEmpleado = new TableColumn("empl");
        idEmpleado.setMinWidth(200);
        idEmpleado.setCellValueFactory(new PropertyValueFactory<>("idEmpleado"));

        TableColumn NumTransacciones = new TableColumn("cant");
        NumTransacciones.setMinWidth(200);
        NumTransacciones.setCellValueFactory(new PropertyValueFactory<>("cantidadVentas"));

        TableColumn TotalVendido = new TableColumn("sumaxd");
        TotalVendido.setMinWidth(200);
        TotalVendido.setCellValueFactory(new PropertyValueFactory<>("totalVendido"));

        tabla.getColumns().addAll(idEmpleado, NumTransacciones, TotalVendido);

        cerrar = new Button("Cerrar");
        cerrar.setPrefSize(160, 80);
        cerrar.setOnAction(e -> stage.close());

        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, tabla, cerrar);
    }

    @Override
    public void generarReporte() {

    }

    private ObservableList<ReporteSemanalClass> ejecutarQuery() {
        ObservableList obs = null;
        ArrayList<ReporteSemanalClass> lista = new ArrayList<>();

        try {
            ConexionPostgresql conexion = new ConexionPostgresql();

            String query = "select t.idempleado as empl, sq.cantidad as cant, sq2.suma as sumaxd \n"
                    + "from transaccion t, (select t.idempleado as empleado, count(t.idtransaccion) as cantidad \n"
                    + "from transaccion t \n where t.tipo like ?"
                    + "group by empleado) sq , (select t.idtransaccion as transac, sum(a.precio) as suma \n"
                    + "from transaccion t \n"
                    + "join  articulostransaccion at on at.idtransaccion = t.idtransaccion \n"
                    + "join articulo a on a.idarticulo = at.idarticulo \n"
                    + "where t.tipo like ? \n group by transac) sq2 \n"
                    + "where t.idempleado = sq.empleado and t.idtransaccion = sq2.transac";

            PreparedStatement statements = conexion.getCnx().
                    prepareStatement(query);
            statements.setString(1, "venta");
            statements.setString(2, "venta");

            ResultSet result = statements.executeQuery();
            while (result.next()) {
                String empleado = result.getString("empl");
                Integer numTransacciones = result.getInt("cant");
                float total = result.getFloat("sumaxd");

                ReporteSemanalClass reporte = new ReporteSemanalClass(empleado, numTransacciones, total);
                lista.add(reporte);
            }

            obs = FXCollections.observableArrayList(lista);
            return obs;

        } catch (SQLException ex) {
            Logger.getLogger(ReporteVentasSemanales.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obs;
    }

    private void setupStage() {
        stage = new Stage();
        scene = new Scene(this.root, 600, 400);
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

}

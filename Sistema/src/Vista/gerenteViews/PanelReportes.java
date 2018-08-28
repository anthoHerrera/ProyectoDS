/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.gerenteViews;

import Modelo.Ctes;
import Strategy.reportes.ReporteVentasSemanales;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Anthony777
 */
class PanelReportes {
    private final VBox root;
    private Label titulo;
    private Button articulos, ventas, clientes, regresar;
    private Stage reporteStage;
    private Scene scene;

    public PanelReportes() {
        root = new VBox(50);
        setPanes();
        setFunctButtons();
        setStage();
    }

    public VBox getRoot() {
        return root;
    }

    private void setPanes() {
        root.setPadding(new Insets(20, 20, 20, 20));
        titulo = new Label("Reportes");
        titulo.setFont(Font.font("Cambria", 32));
        
        articulos = new Button("CANTIDAD DE ARTICULOS");
        ventas = new Button("VENTAS SEMANALES");
        clientes = new Button("CLIENTES POR MES");        
        regresar = new Button("REGRESAR");
                
        articulos.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        ventas.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        clientes.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);        
        regresar.setPrefSize(Ctes.BUT_WIDTH + 60, Ctes.BUT_HEIGHT - 40);
        
        root.setStyle("-fx-background-color: lavender");
        root.getChildren().addAll(titulo, articulos, ventas, clientes, regresar);
        root.setAlignment(Pos.CENTER);
    }

    private void setFunctButtons() {
        articulos.setOnAction(e -> {
            showNArticulos();
        });
        
        articulos.setOnMouseEntered(e -> {
            articulos.setScaleX(1.5);
            articulos.setScaleY(1.5);
        });
        
        articulos.setOnMouseExited(e -> {
            articulos.setScaleX(1);
            articulos.setScaleY(1);
        });
        
        ventas.setOnAction(e ->  {
            showVentasSemanales();
        });
        
        ventas.setOnMouseEntered(e -> {
            ventas.setScaleX(1.5);
            ventas.setScaleY(1.5);
        });
        
        ventas.setOnMouseExited(e -> {
            ventas.setScaleX(1);
            ventas.setScaleY(1);
        });
        
        clientes.setOnAction(e -> {
            showClientesXMes();
        });
        
        clientes.setOnMouseEntered(e -> {
            clientes.setScaleX(1.5);
            clientes.setScaleY(1.5);
        });
        
        clientes.setOnMouseExited(e -> {
            clientes.setScaleX(1);
            clientes.setScaleY(1);
        });
        
        regresar.setOnAction(e -> reporteStage.close());
        
        regresar.setOnMouseEntered(e -> {
            regresar.setScaleX(1.5);
            regresar.setScaleY(1.5);
        });
        
        regresar.setOnMouseExited(e -> {
            regresar.setScaleX(1);
            regresar.setScaleY(1);
        });
    }

    private void setStage() {
        reporteStage = new Stage();
        scene = new Scene(this.getRoot(), Ctes.APP_WIDHT, Ctes.APP_HEIGHT);
        reporteStage.setScene(scene);
        reporteStage.setTitle("Interfaz de Reportes de Gerente");
        reporteStage.showAndWait();
    }
    
    private void showNArticulos() {
        ReporteCantidadArticulo panel = new ReporteCantidadArticulo();
    }
    
    private void showVentasSemanales() {
        ReporteVentasSemanales panel = new ReporteVentasSemanales();
    }
    
    private void showClientesXMes() {
        ReporteClientesXmes panel = new ReporteClientesXmes();
    }
    
    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Oops!");
        alert.setHeaderText("Not implemented yet.");
        alert.setContentText("Sorry not sorry xd.");
        alert.showAndWait();

    }
    
}

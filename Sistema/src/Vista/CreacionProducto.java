/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author JuanFlores
 */
class CreacionProducto {

    private VBox root;
    private Stage creacion;
    private HBox h1, h2, h3, h4, h5,h6,h7,h8,h9,h10,h11,h12,h13;
    private Label l1, l2, l3, l4, l5,l6,l7,l8,l9,l10,l11,l12;
    private TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    private ComboBox<String> cb;
    private ComboBox<Integer> cb2;
    private Button bt;
    private int avance = 0;

    /**
     * Agrega el Stage anterior al nuevo Stage, para tenerlo como referencia y
     * volver a él
     *
     * @param panel
     */
    public CreacionProducto() {
//        this.panel = panel;
        root = new VBox();
        creacion = new Stage();
        creacion.setResizable(false);
        creacion.setTitle("Crear Producto");

        creacion.initModality(Modality.WINDOW_MODAL);

        Scene scene = new Scene(root, 500, 700);
        creacion.setScene(scene);

        setUpLabels();
        setUpTextFields();
        setUpButton();
        setUpHBoxes();
        root.getChildren().addAll(h1, h2, h3, h4, h5,h6,h7,h8,h9,h10,h11,h12,h13);
        root.setSpacing(20);

        creacion.showAndWait();

    }

    /**
     * Setea los HBoxes del Stage
     */
    public void setUpHBoxes() {
        h1 = new HBox();h2 = new HBox();h3 = new HBox();h4 = new HBox();h5 = new HBox();
        h6 = new HBox();h7 = new HBox();h8 = new HBox();h9 = new HBox();h10 = new HBox();
        h11 = new HBox();h12 = new HBox();h13 = new HBox();
        h1.getChildren().addAll(l1, t1);h2.getChildren().addAll(l2, t2);h3.getChildren().addAll(l3, t3);
        h4.getChildren().addAll(l4, t4);h5.getChildren().addAll(l5, t5);h6.getChildren().addAll(l6, t6);
        h7.getChildren().addAll(l7, t7);h8.getChildren().addAll(l8, t8);h9.getChildren().addAll(l9, t9);
        h10.getChildren().addAll(l10,t10);h11.getChildren().addAll(l11, t11);h12.getChildren().addAll(l12, t12);
        h13.getChildren().addAll(bt);

    }

    /**
     * Setea los Labels del Stage
     */
    public void setUpLabels() {
        l1 = new Label("Nombre:");
        l2 = new Label("Descripción:");
        l3 = new Label("Marca:");
        l4 = new Label("Precio:");
        l5 = new Label("Tamaño:");
        l6 = new Label("Potencia total:");
        l7 = new Label("Inductores:");
        l8 = new Label("Voltaje");
        l9 = new Label("Cantidad Puertas:");
        l10 = new Label("Capacidad:");
        l11 = new Label("Filtro de agua:");
        l12 = new Label("Niveles de temperatura: ");

    }

    /**
     * Setea los TextFields del Stage
     */
    public void setUpTextFields() {
        t1 = new TextField();t2 = new TextField();t3 = new TextField();t4 = new TextField();
        t5 = new TextField();t6 = new TextField();t7 = new TextField();t8 = new TextField();
        t9 = new TextField();t10 = new TextField();t11 = new TextField();t12 = new TextField();
    }

    /**
     * Setea los Botones del Stage
     */
    public void setUpButton() {
        bt = new Button("Agregar");
//        bt.setOnAction(new ActionHandler());
    }

    /**
     * Setea los ComboBoxes del Stage
     */
    

//    /**
//     * Llama al método que escribe los archivos binarios serializados Vuelve al
//     * Stage anterior
//     *
//     * @param p
//     */
//    private void registrar(Proyecto p) {
//        ProyectoData.writeProyectos(p);
//        panel.setUpProyects();
//    }

//    private class ActionHandler implements EventHandler<ActionEvent> {
//
//        /**
//         * Sobreescrito para indicar cómo se guarda el nuevo objeto Proyecto
//         * tanto si es un proyecto Individual como Grupal
//         *
//         * @param event
//         */
//        @Override
//        public void handle(ActionEvent event) {
//            try {
//                if (cb.getValue().equals("Individual")) {
//                    Proyecto p = new Proyecto(
//                            t1.getText().trim(),
//                            t2.getValue(),
//                            t3.getValue(),
//                            avance,
//                            cb.getValue(), 1);
//                    registrar(p);
//                } else {
//                    Proyecto p = new Proyecto(
//                            t1.getText().trim(),
//                            t2.getValue(),
//                            t3.getValue(),
//                            avance,
//                            cb.getValue() + " / " + cb2.getValue(), cb2.getValue());
//                    registrar(p);
//                }
//                creacion.close();
//            } catch (NullPointerException ex) {
//                this.alarm(ex.getMessage());
//                
//            }
//        }

        private void alarm(String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error al registrar el proyecto! Verifique ");
            alert.setContentText(message);

            alert.showAndWait();
        }
//    }

        /**
         * Retorna el root del Stage
         */
        public Pane getRoot() {
            return root;
        }
    }

package org.example.pizzeriaapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.pizzeriaapp.model.Pedido;

import java.net.URL;
import java.util.ResourceBundle;

public class PizzeriaController implements Initializable {

    @FXML
    private ListView<Pedido> lista;

    @FXML
    private TextField nombre;

    @FXML
    private RadioButton rbFamiliar;

    @FXML
    private RadioButton rbMediana;

    @FXML
    private RadioButton rbPequeña;

    @FXML
    private Button realizarPedido;

    @FXML
    private TextField telefono;

    @FXML
    private ComboBox<String> tipoPizza;

    private final ObservableList<Pedido> listaPedidos = FXCollections.observableArrayList();
    private ToggleGroup grupoCondicion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoPizza.setItems(FXCollections.observableArrayList(
                "Barbacoa", "Hawaiana", "Jamón y Queso", "Cuatro Quesos"
        ).sorted());

        ToggleGroup grupoCondicion = new ToggleGroup();
        rbFamiliar.setToggleGroup(grupoCondicion);
        rbMediana.setToggleGroup(grupoCondicion);
        rbPequeña.setToggleGroup(grupoCondicion);


        acciones();
    }

    private void acciones() {
        realizarPedido.setOnAction(e -> agregarPedido());
    }

    private void agregarPedido(){
        if (nombre.getText().isEmpty()
        || telefono.getText().isEmpty()
        ) {
            System.out.println("Faltan Datos");
        } else{
            Pedido pedido = new Pedido(1, nombre.getText(), telefono.getText(), tipoPizza.getSelectionModel().getSelectedItem());
            listaPedidos.add(pedido);
            lista.setItems(listaPedidos);
        }
    }


}



package org.example.formularioapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable{

    @FXML
    private TextField nameField, surnameField, emailField;

    @FXML
    private RadioButton femaleRadioButton, maleRadioButton;

    @FXML
    private Button addButton, deleteButton, detailButton;

    @FXML
    private ToggleButton toggleButton;

    @FXML
    private CheckBox availableCheck;

    @FXML
    private ComboBox<Integer> choiceBox;

    @FXML
    private Label panelLista;

    @FXML
    BorderPane panelGeneral;

    private ToggleGroup grupoGenero;

    private ObservableList<Integer> listaEdades;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();

        acciones();
    }

    private void acciones() {

        toggleButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                                Boolean aBoolean, Boolean newValue) {
                if (newValue){
                    panelGeneral.setRight(panelLista);
                } else {
                    panelGeneral.setRight(null);
                }

            }
        });

    }

    private void initGUI() {
        panelGeneral.setRight(null);
        grupoGenero.getToggles().addAll(femaleRadioButton, maleRadioButton);
        choiceBox.setItems(listaEdades);
    }

    private void instancias() {
        grupoGenero = new ToggleGroup();
        listaEdades = FXCollections.observableArrayList();
        for (int i = 18; i < 90; i++) {
            listaEdades.add(i);
        }
    }
}

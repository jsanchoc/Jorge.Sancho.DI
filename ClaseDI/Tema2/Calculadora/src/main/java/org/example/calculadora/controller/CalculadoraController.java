package org.example.calculadora.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {

    private double primerNumero = 0;
    private String operadorActual = "";
    private boolean nuevoNumero = true;

    @FXML
    private TextField display;

    @FXML
    private Button
            botonBorrar, botonComa, botonCoseno, botonDividir, botonIgual, botonLimpiar,
            botonMasMenos, botonMultiplicar, botonPI, botonPorcentaje, botonPotencia,
            botonPotencia2, botonPotencia3, botonRaizCuadrada, botonSeno, botonRestar,
            botonSumar, botonTangente;

    @FXML
    private Button
            numero0, numero1, numero2, numero3,
            numero4, numero5, numero6,
            numero7, numero8, numero9;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();

        acciones();
    }

    private void acciones() {
        numero0.setOnAction(e -> escribirNumero("0"));
        numero1.setOnAction(e -> escribirNumero("1"));
        numero2.setOnAction(e -> escribirNumero("2"));
        numero3.setOnAction(e -> escribirNumero("3"));
        numero4.setOnAction(e -> escribirNumero("4"));
        numero5.setOnAction(e -> escribirNumero("5"));
        numero6.setOnAction(e -> escribirNumero("6"));
        numero7.setOnAction(e -> escribirNumero("7"));
        numero8.setOnAction(e -> escribirNumero("8"));
        numero9.setOnAction(e -> escribirNumero("9"));

        botonSumar.setOnAction(e -> operadores("+"));
        botonRestar.setOnAction(e -> operadores("-"));
        botonMultiplicar.setOnAction(e -> operadores("*"));
        botonDividir.setOnAction(e -> operadores("/"));

        botonLimpiar.setOnAction(e -> limpiar());

        botonIgual.setOnAction(e -> operar());
    }

    private void initGUI() {
    }

    private void instancias() {
    }

    private void escribirNumero(String numero) {
        if (nuevoNumero || display.getText().equals("0")) {
            display.setText(numero);
            nuevoNumero = false;
        } else {
            display.appendText(numero);
        }
    }

    private void limpiar() {
        if (!display.getText().equals("0")) {
            display.setText("0");
        }
    }

    private void operadores(String operador) {
        try {
            primerNumero = Double.parseDouble(display.getText());
            operadorActual = operador;
            nuevoNumero = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }


    private void operar() {
        try {
            double segundoNumero = Double.parseDouble(display.getText());
            double resultado = 0;

            switch (operadorActual) {
                case "+" -> resultado = primerNumero + segundoNumero;
                case "-" -> resultado = primerNumero - segundoNumero;
                case "*" -> resultado = primerNumero * segundoNumero;
                case "/" -> resultado = primerNumero / segundoNumero;
            }

            if (resultado == (int) resultado) {
                display.setText(String.valueOf((int) resultado));
            } else {
                display.setText(String.valueOf(resultado));
            }

            primerNumero = resultado;
            nuevoNumero = true;

        } catch (NumberFormatException | ArithmeticException e) {
            display.setText("Error");
        }
    }
}

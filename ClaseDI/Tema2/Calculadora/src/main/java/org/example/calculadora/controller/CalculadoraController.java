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
        botonPotencia.setOnAction(e -> operadores("^"));


        botonIgual.setOnAction(e -> operar());
        botonLimpiar.setOnAction(e -> limpiar());
        botonBorrar.setOnAction(e -> borrar());
        botonComa.setOnAction(e -> coma());
        botonMasMenos.setOnAction(e -> cambiarSigno());


        botonPI.setOnAction(e -> insertarPI());
        botonPorcentaje.setOnAction(e -> porcentaje());
        botonPotencia2.setOnAction(e -> elevar2());
        botonPotencia3.setOnAction(e -> elevar3());
        botonRaizCuadrada.setOnAction(e -> raiz());
        botonSeno.setOnAction(e -> seno());
        botonCoseno.setOnAction(e -> coseno());
        botonTangente.setOnAction(e -> tangente());
    }

    private void initGUI() {}
    private void instancias() {}

    private void escribirNumero(String numero) {
        if (nuevoNumero || display.getText().equals("0")) {
            display.setText(numero);
            nuevoNumero = false;
        } else {
            display.appendText(numero);
        }
    }

    private void operadores(String operador) {
        try {
            primerNumero = Double.parseDouble(display.getText());
            operadorActual = operador;
            nuevoNumero = true;
        } catch (Exception e) {
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
                case "^" -> resultado = Math.pow(primerNumero, segundoNumero);
            }

            mostrar(resultado);

            primerNumero = resultado;
            nuevoNumero = true;

        } catch (Exception e) {
            display.setText("Error");
        }
    }



    private void mostrar(double resultado) {
        if (resultado == (int) resultado)
            display.setText(String.valueOf((int) resultado));
        else
            display.setText(String.valueOf(resultado));
    }

    private void limpiar() {
        display.setText("0");
        nuevoNumero = true;
        primerNumero = 0;
        operadorActual = "";
    }

    private void borrar() {
        if (display.getText().length() > 1) {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
        } else {
            display.setText("0");
            nuevoNumero = true;
        }
    }

    private void coma() {
        if (!display.getText().contains(".")) {
            display.appendText(".");
        }
    }

    private void cambiarSigno() {
        try {
            double n = Double.parseDouble(display.getText());
            mostrar(-n);
        } catch (Exception ignored) {}
    }

    

    private void insertarPI() {
        display.setText(String.valueOf(Math.PI));
        nuevoNumero = true;
    }

    private void porcentaje() {
        try {
            double n = Double.parseDouble(display.getText()) / 100;
            mostrar(n);
            nuevoNumero = true;
        } catch (Exception ignored) {}
    }

    private void elevar2() {
        try {
            double n = Math.pow(Double.parseDouble(display.getText()), 2);
            mostrar(n);
            nuevoNumero = true;
        } catch (Exception ignored) {}
    }

    private void elevar3() {
        try {
            double n = Math.pow(Double.parseDouble(display.getText()), 3);
            mostrar(n);
            nuevoNumero = true;
        } catch (Exception ignored) {}
    }

    private void raiz() {
        try {
            double n = Math.sqrt(Double.parseDouble(display.getText()));
            mostrar(n);
            nuevoNumero = true;
        } catch (Exception ignored) {}
    }

    private void seno() {
        try {
            double n = Math.sin(Math.toRadians(Double.parseDouble(display.getText())));
            mostrar(n);
        } catch (Exception ignored) {}
    }

    private void coseno() {
        try {
            double n = Math.cos(Math.toRadians(Double.parseDouble(display.getText())));
            mostrar(n);
        } catch (Exception ignored) {}
    }

    private void tangente() {
        try {
            double n = Math.tan(Math.toRadians(Double.parseDouble(display.getText())));
            mostrar(n);
        } catch (Exception ignored) {}
    }
}
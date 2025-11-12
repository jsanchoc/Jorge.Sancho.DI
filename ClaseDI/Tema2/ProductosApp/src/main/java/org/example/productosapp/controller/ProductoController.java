package org.example.productosapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.productosapp.model.Producto;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductoController implements Initializable {

    @FXML
    private Button botonAgregar;
    @FXML
    private Button botonDetalle;
    @FXML
    private Button botonEliminar;
    @FXML
    private Button botonLimpiar;
    @FXML
    private ComboBox<String> categoriaProducto;
    @FXML
    private CheckBox envio;
    @FXML
    private ListView<Producto> lista;
    @FXML
    private TextField marca;
    @FXML
    private TextField nombreProducto;
    @FXML
    private TextField precio;
    @FXML
    private RadioButton radioButtonNuevo;
    @FXML
    private RadioButton radioButtonUsado;
    @FXML
    private TextField stockDisponible;


    private final ObservableList<Producto> productos = FXCollections.observableArrayList();
    private ToggleGroup grupoCondicion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Asociar lista
        lista.setItems(productos);

        // Rellenar categorías
        categoriaProducto.setItems(FXCollections.observableArrayList(
                "Electrónica", "Ropa", "Alimentación", "Hogar", "Juguetes"
        ).sorted());

        // Configurar grupo de radio buttons
        grupoCondicion = new ToggleGroup();
        radioButtonNuevo.setToggleGroup(grupoCondicion);
        radioButtonUsado.setToggleGroup(grupoCondicion);
        radioButtonNuevo.setSelected(true);

        // Conectar acciones
        acciones();
    }

    private void acciones() {
        botonAgregar.setOnAction(e -> agregarProducto());
        botonEliminar.setOnAction(e -> eliminarProducto());
        botonDetalle.setOnAction(e -> mostrarDetalle());
        botonLimpiar.setOnAction(e -> limpiarCampos());

        lista.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) mostrarDetalle();
        });
    }

    private void agregarProducto() {
        String nombre = nombreProducto.getText().trim();
        String marcaTxt = marca.getText().trim();
        String precioTxt = precio.getText().trim();
        String stockTxt = stockDisponible.getText().trim();
        String categoria = categoriaProducto.getValue();
        String condicion = ((RadioButton) grupoCondicion.getSelectedToggle()).getText();
        boolean envioOnline = envio.isSelected();

        if (nombre.isEmpty() || marcaTxt.isEmpty() || precioTxt.isEmpty() || stockTxt.isEmpty() || categoria == null) {
            mostrarAlerta("Por favor, completa todos los campos.");
            return;
        }

        double precioNum;
        int stockNum;

        try {
            precioNum = Double.parseDouble(precioTxt.replace(',', '.'));
            stockNum = Integer.parseInt(stockTxt);
        } catch (NumberFormatException ex) {
            mostrarAlerta("Introduce valores numéricos válidos para precio y stock.");
            return;
        }

        Producto producto = new Producto(nombre, marcaTxt, precioNum, stockNum, categoria, condicion, envioOnline);
        productos.add(producto);
        limpiarCampos();
    }

    private void eliminarProducto() {
        Producto seleccionado = lista.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un producto para eliminar.");
            return;
        }
        productos.remove(seleccionado);
    }

    private void mostrarDetalle() {
        Producto seleccionado = lista.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un producto para ver su detalle.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Detalle del Producto");
        alert.setHeaderText(seleccionado.getNombre() + " - " + seleccionado.getMarca());
        alert.setContentText(
                "Precio: " + seleccionado.getPrecio() + "\n" +
                        "Stock: " + seleccionado.getStock() + "\n" +
                        "Categoría: " + seleccionado.getCategoria() + "\n" +
                        "Condición: " + seleccionado.getCondicion() + "\n" +
                        "Envío Online: " + (seleccionado.isEnvioOnline() ? "Sí" : "No")
        );
        alert.showAndWait();
    }

    private void limpiarCampos() {
        nombreProducto.clear();
        marca.clear();
        precio.clear();
        stockDisponible.clear();
        categoriaProducto.getSelectionModel().clearSelection();
        radioButtonNuevo.setSelected(true);
        envio.setSelected(false);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
package controlador;

import dao.TiendaDAO;
import modelo.Producto;
import modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TiendaController {

    @FXML
    private ListView<Producto> listaProductos;

    @FXML
    private Label lblTotal;

    private TiendaDAO dao = new TiendaDAO();
    private Usuario usuarioLogeado;

    private List<Producto> carrito = new ArrayList<>();

    public void initialize() {
        cargarProductos();
    }

    public void initData(Usuario usuario) {
        this.usuarioLogeado = usuario;
        System.out.println("Bienvenido a la tienda: " + usuario.getNombre());
    }

    private void cargarProductos() {
        List<Producto> productosBD = dao.obtenerProductos();
        ObservableList<Producto> items = FXCollections.observableArrayList(productosBD);
        listaProductos.setItems(items);
    }

    @FXML
    public void handleComprar(ActionEvent event) {
        Producto seleccionado = listaProductos.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Error", "Selecciona un producto de la lista primero.");
            return;
        }

        carrito.add(seleccionado);
        actualizarTextoTotal();
        mostrarAlerta("Éxito", "Producto añadido al carrito.");
    }

    @FXML
    public void handleVaciar(ActionEvent event) {
        carrito.clear();
        actualizarTextoTotal();
        mostrarAlerta("Carrito", "El carrito se ha vaciado.");
    }

    @FXML
    public void handleVer(ActionEvent event) {
        StringBuilder texto = new StringBuilder("Tu Carrito:\n");
        double totalPrecio = 0;

        for (Producto p : carrito) {
            texto.append("- ").append(p.getNombre()).append(" (").append(p.getPrecio()).append("€)\n");
            totalPrecio += p.getPrecio();
        }

        texto.append("\nTotal a pagar: ").append(totalPrecio).append("€");
        mostrarAlerta("Resumen del Pedido", texto.toString());
    }

    private void actualizarTextoTotal() {
        lblTotal.setText("Total en carrito: " + carrito.size() + " productos");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
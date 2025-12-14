package controlador;

import dao.TiendaDAO;
import modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    private TiendaDAO dao = new TiendaDAO();

    @FXML
    public void handleLogin(ActionEvent event) {
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();

        if (correo.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "Por favor, rellena todos los campos.");
            return;
        }

        Usuario usuario = dao.validarLogin(correo, password);

        if (usuario != null) {
            System.out.println("Login correcto: " + usuario.getNombre());
            abrirTienda(event, usuario);
        } else {
            mostrarAlerta("Login Fallido", "El correo o la contraseña no son correctos.");
        }
    }

    private void abrirTienda(ActionEvent event, Usuario usuario) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/tienda/Tienda.fxml"));
            Parent root = loader.load();
            TiendaController controlador = loader.getController();
            controlador.initData(usuario);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Catálogo de Productos");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error Fatal", "No se pudo cargar la pantalla de la tienda.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
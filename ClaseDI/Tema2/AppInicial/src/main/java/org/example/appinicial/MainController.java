package org.example.appinicial;

import com.almasb.fxgl.entity.action.Action;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // Llamar a cada una de las variables de la parte gráfica
    @FXML
    private Button botonEnviar, botonVaciar, botonLimpiar;

    @FXML
    private Label labelSaludo;

    @FXML
    private TextField textFieldNombre;

    private String textoOriginal;

    private DropShadow sombra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
        textoOriginal = labelSaludo.getText();
    }

    private void initGUI() {
    }

    private void instancias() {
        sombra = new DropShadow();
    }


    private void acciones() {
        botonEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelSaludo.setText("Enhorabuena " + textFieldNombre.getText() + " Proyecto Completo");
                textFieldNombre.clear();
            }
        });
        botonVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textFieldNombre.clear();
            }
        });
        botonLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelSaludo.setText(textoOriginal);
            }
        });
        botonEnviar.setOnMouseEntered(new ManejadorRaton());
        botonVaciar.setOnMouseEntered(new ManejadorRaton());
        botonLimpiar.setOnMouseEntered(new ManejadorRaton());
        botonEnviar.setOnMouseExited(new ManejadorRaton());
        botonVaciar.setOnMouseExited(new ManejadorRaton());
        botonLimpiar.setOnMouseExited(new ManejadorRaton());


    }

    class ManejadorAcciones implements EventHandler<ActionEvent>{
        // el parametro actionEvent es el evento que se ha producido
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonEnviar){
                System.out.println("Botón Enviar Pulsado");
            } else if (actionEvent.getSource() == botonVaciar) {
                System.out.println("Botón Vaciar Pulsado");
            } else if (actionEvent.getSource() == botonLimpiar) {
                System.out.println("Botón Limpiar Pulsado");
            }
        }
    }

    class ManejadorRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent){
            Button button = (Button) mouseEvent.getSource();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                button.setEffect(sombra);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                button.setEffect(null);
            }

        }
    }

    class ManejadorGeneral implements EventHandler<Event>{

        @Override
        public void handle(Event event) {

        }
    }



}


































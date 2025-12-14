module org.example.tienda {
    // Librerías necesarias
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens controlador to javafx.fxml;

    exports org.example.tienda;

    opens org.example.tienda to javafx.fxml;
}
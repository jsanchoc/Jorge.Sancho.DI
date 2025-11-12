module org.example.pizzeriaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires static lombok;

    opens org.example.pizzeriaapp to javafx.fxml;
    opens org.example.pizzeriaapp.controller to javafx.fxml;
    exports org.example.pizzeriaapp;
}
module org.example.productosapp {
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

    opens org.example.productosapp.controller to javafx.fxml;
    exports org.example.productosapp;
    exports org.example.productosapp.model;
    opens org.example.productosapp.model to javafx.fxml;
}
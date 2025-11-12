package org.example.productosapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private String nombre;
    private String marca;
    private double precio;
    private int stock;
    private String categoria;
    private String condicion;
    private boolean envioOnline;

    @Override
    public String toString() {
        return nombre + " - " + marca;
    }
}
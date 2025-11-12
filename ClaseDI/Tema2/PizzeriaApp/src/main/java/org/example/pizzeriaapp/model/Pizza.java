package org.example.pizzeriaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pizza {
    private String nombre;
    private String tamano;
    private int precio;

    @Override
    public String toString() {
        return nombre + " " + tamano + " " + precio;
    }
}

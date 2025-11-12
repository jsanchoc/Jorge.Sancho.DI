package org.example.pizzeriaapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {
    private int id;
    private String name;
    private String phone;
    private String pizza;

    @Override
    public String toString() {
        return id + " " + name + " " + phone + " " + pizza;
    }
}
import model.Saludar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lecturaTeclado = new Scanner(System.in);
        Saludar saludar = new Saludar();
        saludar.saludar();
        System.out.println("Introduzca su nombre: ");
        String nombre = lecturaTeclado.next();
        saludar.saludarPerso(nombre);
        saludar.sumar(7, 26);

        }

}

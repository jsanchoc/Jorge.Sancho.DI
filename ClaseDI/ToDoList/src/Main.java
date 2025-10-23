
import model.Encargo;
import model.Persona;
import model.Tarea;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("1234567E", "Jorge", "Sancho", 23);
        Encargo encargo = new Encargo(1, "Eat Healthy", "Vas a comer sano durante 3 meses", persona, false);

        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 5) {
            System.out.println("**********MENU**********");
            System.out.println("*1. Añadir Encargo     *");
            System.out.println("*2. Ver Encargo        *");
            System.out.println("*3. Completar Encargo  *");
            System.out.println("*4. Eliminar Encargo   *");
            System.out.println("*5. Salir              *");
            System.out.println("************************");
            System.out.println("Elije una opción: ");

            option = sc.nextInt();
            switch (option) {
                case 1:
                    encargo.agregarEncargo(encargo);
                case 2:
                    encargo.mostrarEncargo(1);
                case 3:
                    encargo.completarEncargo(1);
                case 4:
                    encargo.eliminarEncargo(1);
                case 5:
                    break;
            }
        }
    }
}

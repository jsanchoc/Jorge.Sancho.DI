import java.util.Scanner;

public class Entrada {
    /*
    // variables
    final String DNI = "12345329T";
    String palabra = "aklsdjha";
    char letra = 'J';
    int numero = 33;
    double altura = 33.33;
    float base = 12.23f;
    boolean exito = true;

     */

    // constructores
    // métodos
    // fun main(args:Array<String>){}
    public static void main(String[] args){

        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Por favor introduce tu nombre");
        String nombre = lecturaTeclado.next();
        System.out.println("Por favor introduce tu edad");
        int edad = lecturaTeclado.nextInt();
        System.out.println("Primer programa en Java");
        System.out.printf("Mi nombre es %s y tengo %d\n",nombre,edad);

    }


}


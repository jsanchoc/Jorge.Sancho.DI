import java.util.Scanner;

public class SentenciasControl {

    // variables
    // constructores --> ()
    // métodos

    // fun nombre():retorno{
    // }

    public void sentenciasCondicionales(){
        int nota = 10;
        char letra = 'A';
        switch (letra){
            case 'A':
                break;
        }
    }
    public void sentenciasRepeticion(){
        int[] elementos = {1,2,3,4,5,6,7};
        int[][] elementosMulti = {{1,2,3},{4,5,6}};
        String[] palabras = {"asd", "qwe", "zxc"};
        Object[] cosas = {1, true, '2', "askdfsk"};

        /*for (int i = 0; i < elementos.length; i++) {
            System.out.println(elementos[i]);
        }


        //tablas de multiplicar del 0 al 10
        //Tabla del 0

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf("%d * %d = %d%n",i,j,i*j);
            }

         */
        /*
        for (String item : palabras){
            System.out.println(item);
        }
         */
        System.out.print("Indica opción a ejecutar: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                System.out.println("seleccionada opcion 1");
                break;
            case 2:
                System.out.println("seleccionada opcion 2");
                break;
            case 3:
                System.out.println("seleccionada opcion 3");
                break;
            default:
                System.out.println("Opción no contemplada");

        }
    }
}

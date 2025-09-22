public class EstructurasArrays {

    private int[] numeros = new int[9];

    public void incluirNumero(int posicion, int valor){
        if (posicion > numeros.length -1){
            System.out.println("No hay posibilidad, provocará fallo");
        } else {
            numeros[posicion] = valor;

        }
    }
    public void mostrarElementos(){
        for (int item: numeros){
            System.out.printf("Valor %d%n",item);
        }
    }

    public void buscarRepetidos(int numero){
        var repetido = 0;
        for (int item: numeros) {
            if (item == numero){
                repetido++;
            }
        }
        System.out.printf("El numero %d se repite %d veces %n", numero, repetido);
    }

    public boolean estaNumero(int numeroBuscar){
        for (int item: numeros){
            if (item == numeroBuscar){
                return true;
            }
        }
        int aleatorio = (int)(Math.random()*41);
        return false;
    }

    public void rellenarArray(){
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*41);
        }
    }

    public void realizarCalculos(){
        int sumatorio = 0;
        for ( int item : numeros ){
            sumatorio += item;
        }
        double media = (double) sumatorio /numeros.length;
        System.out.println("La suma es "+sumatorio);
        System.out.println("La media es "+media);
    }

}

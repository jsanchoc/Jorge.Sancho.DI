package model;

public class VideojuegoEstrategia extends Videojuego{
    private int complejidad;
    private int duracionPartida;

    public VideojuegoEstrategia() {
    }

    public VideojuegoEstrategia(String titulo, String desarrollador, int añoLanzamiento, double precio, String clasificacionEdad, int complejidad, int duracionPartida) {
        super(titulo, desarrollador, añoLanzamiento, precio, clasificacionEdad);
        this.complejidad = complejidad;
        this.duracionPartida = duracionPartida;
    }


    public void calcularPrecioFinal(Videojuego videojuego) {
        var precio = getPrecio();
        switch (complejidad){
            case 1:
                precio += getPrecio() * 0.03;
            case 2:
                precio += getPrecio() * 0.06;
            case 3:
                precio += getPrecio() * 0.09;
            case 4:
                precio += getPrecio() * 0.12;
            case 5:
                precio += getPrecio() * 0.15;
            }
        System.out.println(precio);
        }
    }




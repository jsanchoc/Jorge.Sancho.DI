package model;

public class VideojuegoAccion extends Videojuego{
    private int nivelViolencia;
    private boolean modoMultijugador;

    public VideojuegoAccion() {
    }

    public VideojuegoAccion(String titulo, String desarrollador, int añoLanzamiento, double precio, String clasificacionEdad, int nivelViolencia, boolean modoMultijugador) {
        super(titulo, desarrollador, añoLanzamiento, precio, clasificacionEdad);
        this.nivelViolencia = nivelViolencia;
        this.modoMultijugador = modoMultijugador;
    }


    public void calcularPrecioFinal(Videojuego videojuego) {
        var precio = getPrecio();
        if (getNivelViolencia() > 3){
            precio += getPrecio() * 0.05;
        }
        if (isModoMultijugador()) {
            precio += getPrecio() * 0.10;
        }
        System.out.println(precio);
    }

    public int getNivelViolencia() {
        return nivelViolencia;
    }

    public void setNivelViolencia(int nivelViolencia) {
        this.nivelViolencia = nivelViolencia;
    }

    public boolean isModoMultijugador() {
        return modoMultijugador;
    }

    public void setModoMultijugador(boolean modoMultijugador) {
        this.modoMultijugador = modoMultijugador;
    }
}



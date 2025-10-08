package model;

abstract public class Videojuego {

    private String titulo;
    private String desarrollador;
    private int añoLanzamiento;
    private double precio;
    private String clasificacionEdad;

    public Videojuego() {
    }

    public Videojuego(String titulo, String desarrollador, int añoLanzamiento, double precio, String clasificacionEdad) {
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.añoLanzamiento = añoLanzamiento;
        this.precio = precio;
        this.clasificacionEdad = clasificacionEdad;
    }

    public void calcularPrecioFinal(VideojuegoAccion videojuegoAccion){

    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    @Override
    public String toString() {
        return "model.Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", desarrollador='" + desarrollador + '\'' +
                ", añoLanzamiento=" + añoLanzamiento +
                ", precio=" + precio +
                ", clasificacionEdad='" + clasificacionEdad + '\'' +
                '}';
    }
}

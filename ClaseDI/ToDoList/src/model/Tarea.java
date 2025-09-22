package model;

public class Tarea {

    // variables
    private int id, horasEmpleadas;

    private String titulo, descripcion;

    private boolean completada;


    public Tarea() {
    }

    // constructores -> el vacio (desaparece cuando se escribe uno)
    public Tarea(int id, String titulo, String descripcion){
        this.id = 1;
        this.titulo = titulo;
        this.descripcion = descripcion;
        // completada = false;
    }

    public Tarea(int id, int horasEmpleadas, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.horasEmpleadas = horasEmpleadas;
    }

    // metodos -> getter setter
    public void setTitulo(String titulo){
        if (titulo.length() < 5){
            this.titulo = titulo;
        }
        System.out.println("NO noseq");
    }

    public String getTitulo(int pin){
        if (pin == 1234){
            return titulo;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", horasEmpleadas=" + horasEmpleadas +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                '}';
    }
}



package model;

public class Encargo{

    private int id;
    private String titulo;
    private boolean completo;

    public Encargo() {
    }

    public Encargo(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }
}

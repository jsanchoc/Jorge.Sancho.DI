package model;

public class Encargo extends Tarea {

    private boolean realizado;

    public Encargo() {
        super();
    }

    public Encargo(int id, String titulo, String descripcion, Persona responsable, boolean realizado) {
        super(id, titulo, descripcion, responsable);
        this.realizado = realizado;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    @Override
    public String toString() {
        return super.toString() + ", realizado=" + realizado + "}";
    }

    @Override
    public void agregarEncargo(Encargo encargo) {
        super.agregarEncargo(encargo);
    }

    @Override
    public void mostrarEncargos() {
        super.mostrarEncargos();
    }

    @Override
    public void eliminarEncargo(int id) {
        super.eliminarEncargo(id);
    }

    @Override
    public void completarEncargo(int id) {
        super.completarEncargo(id);
    }
}

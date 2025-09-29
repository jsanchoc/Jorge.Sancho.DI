package model;

public class Persona {

    private String nombre, apellido, dni;

    private int edad;

    public Persona() {
    }

    public Persona(String nombre, String dni, String apellido, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("\tapellido = " + apellido);
        System.out.println("\tedad = " + edad);
        System.out.println("\tdni = " + dni);
    }
}

package model;

abstract public class Trabajador extends Persona{

    private int telefono, nss;
    private double salario;
    private String correo;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellido, int edad, int telefono, int nss, double salario, String correo) {
        super(dni, nombre, apellido, edad);
        this.telefono = telefono;
        this.nss = nss;
        this.salario = salario;
        this.correo = correo;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("telefono = " + telefono);
        System.out.println("nss = " + nss);
        System.out.println("salario = " + salario);
        System.out.println("correo = " + correo);
    }

    abstract public double calcularSalarioNeto();










    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

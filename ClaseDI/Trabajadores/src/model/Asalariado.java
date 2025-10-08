package model;

public class Asalariado extends Trabajador{

    private int nPagas;
    private double irpf;

    public Asalariado(){
    }

    public Asalariado(String dni, String nombre, String apellido, int edad, int telefono, int nss, double salario, String correo, int nPagas, double irpf) {
        super(dni, nombre, apellido, edad, telefono, nss, salario, correo);
        this.nPagas = nPagas;
        this.irpf = irpf;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("nPagas = " + nPagas);
        System.out.println("irpf = " + irpf);
    }

    @Override
    public double calcularSalarioNeto() {
        double salarioNeto = getSalario() - getSalario()*irpf;
        System.out.println("salarioNeto = " + salarioNeto);
        return salarioNeto;
    }

    public void calcularNetoMensual() {
        double netoMes = calcularSalarioNeto()/nPagas;
        System.out.println("netoMes = " + netoMes);

    }


    public int getnPagas() {
        return nPagas;
    }

    public void setnPagas(int nPagas) {
        this.nPagas = nPagas;
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        this.irpf = irpf;
    }
}

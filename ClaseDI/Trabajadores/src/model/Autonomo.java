package model;

public class Autonomo extends Trabajador{

    private double cuotasSS;

    public Autonomo() {
    }

    public Autonomo(String dni, String nombre, String apellido, int edad, int telefono, int nss, double salario, String correo, double cuotasSS) {
        super(dni, nombre, apellido, edad, telefono, nss, salario, correo);
        this.cuotasSS = cuotasSS;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("cuotas = " + cuotasSS);
    }

    @Override
    public double calcularSalarioNeto() {
        double salarioNeto = getSalario() - cuotasSS * 12;
        System.out.println("salarioNeto = " + salarioNeto);;
        return salarioNeto;
    }

    public void aplicarDescuento(int descuento) {
        cuotasSS = cuotasSS - (cuotasSS * descuento/100.0);
    }


    public double getCuotasSS() {
        return cuotasSS;
    }

    public void setCuotasSS(double cuotasSS) {
        this.cuotasSS = cuotasSS;
    }
}
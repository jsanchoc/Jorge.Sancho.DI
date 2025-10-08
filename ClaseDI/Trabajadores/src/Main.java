import model.Asalariado;
import model.Autonomo;
import model.Persona;
import model.Trabajador;

public class Main {

    public static void main(String[] args) {
        // Persona persona = new Persona("1234567E", "Jorge", "Sancho", 23);
        // persona.mostrarDatos();

        // Trabajador trabajador = new Trabajador("1234567E", "Jorge", "Sancho", 23, 658026012, 1233423, 33000.0, "jsancho@gmail.com");
        // trabajador.mostrarDatos();
        Asalariado asalariado = new Asalariado("1234567E", "Jorge", "Sancho", 23, 658026012, 1233423, 33000.0, "jsancho@gmail.com", 12, 0.06);
        asalariado.calcularNetoMensual();
        Autonomo autonomo = new Autonomo("1234567E", "Jorge", "Sancho", 23, 658026012, 1233423, 33000.0, "jsancho@gmail.com", 500);
        autonomo.aplicarDescuento(50);
        autonomo.mostrarDatos();
    }

}

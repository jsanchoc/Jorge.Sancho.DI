import model.Persona;
import model.Tarea;

public class Main {
    public static void main(String[] args) {
        /*
        Tarea tareaPrincipal = new Tarea();
        Tarea tareaSecundaria = new Tarea(1, "Estudiar", "Esta tarea me ayudara a centrarme en el dia a dia del estucio",
                new Persona("1234A", "Borja", "Martin", 41));
        Tarea tareaSecundaria2 = new Tarea(3, "Practicar", "descipcion de la tarea",
                new Persona("2345C", "Juan", "Garcia", 26),
                5);


        // como saco el nombre del respoonsable de la tarea secundaria
        System.out.println(tareaSecundaria.getResponsable().getNombre());


        // cuantas personas hay en el equipo de trabajo de la tarea secundaria
        Persona personaVacia = new Persona();
        Persona persona = new Persona("1234A", "Borja", "Martin", 41);
        System.out.println(tareaPrincipal);
        System.out.println(tareaSecundaria);
        System.out.println(tareaPrincipal.equals(tareaSecundaria));

        System.out.println(personaVacia);
        System.out.println(persona);
        // tareaSecundaria.setTitulo("Estu");
        // System.out.println(tareaSecundaria.getTitulo(1234));

         */
        Tarea tarea = new Tarea(3, "Practicar", "descipcion de la tarea",
                new Persona("2345C", "Juan", "Garcia", 26),
                5);
        System.out.println(tarea.getEquipoTrabajo().length);
        tarea.agragarPersona(new Persona("Jorge", "11123k", "sancho", 23));
        tarea.agragarPersona(new Persona("Javier", "3333k", "pancho", 33));
        tarea.agragarPersona(new Persona("Pepe", "11823k", "saycho", 13));
        tarea.agragarPersona(new Persona("borjita", "98765E", "calbo", 99));
        tarea.agragarPersona(new Persona("Steve", "0987654j", "mulroy", 18));

        tarea.mostrarPersona();

    }
}
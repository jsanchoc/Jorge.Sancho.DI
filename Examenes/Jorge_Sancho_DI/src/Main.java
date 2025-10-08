import model.Videojuego;
import model.VideojuegoAccion;
import model.VideojuegoEstrategia;

public class Main {
    public static void main(String[] args) {
        VideojuegoAccion videojuegoAccion = new VideojuegoAccion("Pacman", "pepe", 1970, 33.3, "pegi3", 4, true);
        videojuegoAccion.calcularPrecioFinal(videojuegoAccion);


        VideojuegoEstrategia videojuegoEstrategia = new VideojuegoEstrategia("Minecraft", "Juan", 2012, 33.3, "pegi13", 4, 5);
        videojuegoEstrategia.calcularPrecioFinal(videojuegoEstrategia);
    }
}

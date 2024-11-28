import java.util.Scanner;
public class InterfazPokemon {
    private Scanner teclado;

    public InterfazPokemon(){
        teclado = new Scanner(System.in);
    }

    public void Juego() {
        System.out.println("");
        Pokemon jugador = menuCreacionPokemonJugador();

        for (int i = 1; i <= 3; i++) {
            Pokemon rival = siguientePokemonRival(i);
            // Presentacion del Pokemon y obligar a pulsar enter con el .nextLine()
            System.out.println("Presentación del pokemon oponente: \n" + rival);
            System.out.println("PULSE ENTER PARA CONTINUAR");
            teclado.nextLine();

            // Si tu Pokemon o el del rival ganan mostrara un mensaje u otro
            Pokemon ganador = Partida(jugador, rival);
            if (ganador == jugador) {
                jugador.subirNivel();
                System.out.println("Genial: Has derrotado a " + rival.getNombre() + "\n -----------------------------");
            } else if (ganador == rival) {
                System.out.println(rival.getNombre() + " te ha derrotado");
                mostrarFinPartida();
                return;
            }
        }
        mostrarJuegoSuperado();
    }

    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival){
        Combate combate = new Combate(pokemonJugador, pokemonRival);
        while (combate.Ganador() == null) {
            combate.Ronda();
        }
        return combate.Ganador();
    }


    private Pokemon menuCreacionPokemonJugador(){
        // Pedir nombre del Pokemon
        System.out.println("Introduce un nombre: ");
        String nombre = teclado.nextLine();
        // Pedir tipo del Pokemon
        System.out.println("Elige su tipo \n 1.- Agua \n 2.- Tierra \n 3.- Fuego \n ------------");
        String tipo = teclado.nextLine();

        // Este while lo he usado para que en caso de que no introduzca el tipo correcto le vuelva a solicitar.
        while (!tipo.equals("1") && !tipo.equals("2") && !tipo.equals("3")) {
            System.out.println("El tipo de Pokemon es incorrecto, elige entre Agua, Tierra o Fuego: ");
            tipo = teclado.nextLine();
        }
        // Devuelve el Pokemon
        return new Pokemon(nombre, tipo);
    }

    public Pokemon siguientePokemonRival(int numero) {
        switch (numero) {
            case 1:
                return new Pokemon("Caterpie", "Tierra", 1);
            case 2:
                return new Pokemon("Bulbasur", "Agua", 2);
            case 3:
                return new Pokemon("Charmander", "Fuego", 3);
            default:
                return null;
        }
    }

    private void mostrarJuegoSuperado(){
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    private void mostrarFinPartida(){
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }

}

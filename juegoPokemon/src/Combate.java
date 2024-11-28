public class Combate {

    // Añada los atributos y el constructor *************
    private Pokemon pokemonJugador;
    private Pokemon pokemonRival;

    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival){
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }



    //***************************************************


    public Pokemon Ronda(){
        int poderJugador = pokemonJugador.calcularPoder(pokemonRival);
        int poderRival = pokemonRival.calcularPoder(pokemonJugador);

        // Si el poder del jugador es mayor al rival llamamos al metodo de disminuir nivel y lo devolvemos
        if (poderJugador > poderRival) {
            pokemonRival.disminuirAguante();
            System.out.println("Aguante de " + pokemonJugador.getNombre() + ":" + pokemonJugador.getAguante());
            System.out.println("Aguante de " + pokemonRival.getNombre() + ":" + pokemonRival.getAguante());
            return pokemonJugador;
        } else if (poderJugador < poderRival) { // Si el poder del rival es mayor al jugador llamamos al metodo de disminuir nivel y lo devolvemos
            pokemonJugador.disminuirAguante();
            System.out.println("Aguante de " + pokemonJugador.getNombre() + ":" + pokemonJugador.getAguante());
            System.out.println("Aguante de " + pokemonRival.getNombre() + ":" + pokemonRival.getAguante());
            return pokemonRival;
        } else {
            return null;
        }
    }

    public Pokemon Ganador(){
        // Si el aguante del pokemon es igual o menor a 0 pierde y muestra que gana el otro
        if (pokemonJugador.getAguante() <= 0) {
            return pokemonRival;
        } else if (pokemonRival.getAguante() <= 0) {
            return pokemonJugador;
        } else {
            return null;
        }
    }
}

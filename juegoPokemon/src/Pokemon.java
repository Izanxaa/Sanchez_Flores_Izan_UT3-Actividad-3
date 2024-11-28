import java.util.Random;

/**
 *
 * La clase Pokemon modela un Pokémon con atributos básicos, calcula su poder en combate según nivel, tipo y ventajas,
 * y permite actualizar su nivel y estadísticas.
 * @author Izan
 * @version 1.0
 * @link Combate
 *
 */
public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;

// Añada los constructores********************

    // Constructor 1
    public Pokemon(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = 1;
        actualizarStats();
    }

    // Constructor 2 enemigos
    public Pokemon(String nombre, String tipo, int nivel){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        actualizarStats();
    }


// ******************************************

    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int calcularPoder(Pokemon contrincante){
        // Completa el método calcularPoder...
        Random aleatorio = new Random(); // aleatorio sera el random
        int poder = 0; // creamos el poder
        // Con este switch cuando encuentre su nivel como todos contienen break saldra en el suyo con su poder aleatorio de su rango
        switch (this.nivel){
            case 1:
                poder = aleatorio.nextInt(8) + 3; // el poder sera aleatorio entre 3 y 10
                break;
            case 2:
                poder = aleatorio.nextInt(15) + 6; // el poder sera aleatorio entre 6 y 20
                break;
            case 3:
                poder = aleatorio.nextInt(22) + 9; // el poder sera aleatorio entre 9 y 30
                break;
            case 4:
                poder = aleatorio.nextInt(29) + 12; // el poder sera aleatorio entre 12 y 40
                break;
        }

        // Hice un if por cada elemento, contra quien tiene ventaja o desventaja
        // Tipo agua
        if (this.tipo.equals("Agua")) {
            if (contrincante.tipo.equals("Fuego")) {
                poder += 2 * this.nivel; // agua vence al fuego
            } else if (contrincante.tipo.equals("Tierra")) {
                poder -= 2 * contrincante.nivel; // agua pierde contra tierra
            }
        }
        else if (this.tipo.equals("Fuego")) {
            if (contrincante.tipo.equals("Agua")) {
                poder -= 2 * contrincante.nivel; // fuego pierde contra agua
            } else if (contrincante.tipo.equals("Tierra")) {
                poder += 2 * this.nivel; // fuego vence a tierra
            }
        }
        else if (this.tipo.equals("Tierra")) {
            if (contrincante.tipo.equals("Agua")) {
                poder += 2 * this.nivel; // tierra vence a agua
            } else if (contrincante.tipo.equals("Fuego")) {
                poder -= 2 * contrincante.nivel; // tierra pierde contra fuego
            }
        }

        // para que el valor de poder no pueda ser negativo, en todo caso 0
        poder = Math.max(poder, 0);
        // devolver poder que se ha calculado
        return poder;
    }




    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();
    }

    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    public void disminuirAguante(){
        this.aguante--;
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }

}

package pkg008_jarras;

/*
    Supongo que las jarras comienzas vacías
    Supongo que al llenar la jarra desde otra jarra la otra jarra no derrama agua
    Supongo que una jarra no se puede llenarse a sí misma
*/
public class Jarra {

    private int contenido;
    private final int CAPACIDAD;

    public Jarra(int capacidad) {
        this.contenido = 0;
        this.CAPACIDAD = capacidad;
    }

    @Override
    public String toString() {
        return "Capacidad: " + CAPACIDAD + "\nContenido: " + contenido + "\n";
    }

    public void llena() {
        contenido = CAPACIDAD;
    }

    public void vacia() {
        contenido = 0;
    }

    public void llenaDesde(Jarra other) {
        int espacioLibre = CAPACIDAD - contenido;
        if(this.equals(other)){                                      // Una jarra no puede llenarse a sí misma
            System.out.println("Operation Failed");
        }
        else if (this.contenido + other.contenido <= espacioLibre) { // Toda la cantidad de la otra jarra cabe en esta
            contenido = contenido + other.contenido;                 // Al contenido de esta jarra añado el contenido de la otra
            other.contenido = 0;                                     // La otra jarra se vacía completamente
        } else {                                                     // Solo cabe parte de la cantidad de la otra jarra
            contenido = CAPACIDAD;                                   // Esta jarra se llena completamente                     
            other.contenido = other.contenido - espacioLibre;        // La otra jarra pierde parte de su contenido
        }
    }

    // Getters & Setters
    public int getContenido() {
        return contenido;
    }

    public int getCapacidad() {
        return CAPACIDAD;
    }

}

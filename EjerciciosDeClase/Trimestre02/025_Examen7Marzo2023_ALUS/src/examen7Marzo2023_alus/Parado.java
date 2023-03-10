package examen7Marzo2023_alus;

import java.util.concurrent.ThreadLocalRandom;

public class Parado implements Persona {

    private String nombre;
    private double subsidio;

    Parado(String nombre) {
        this.nombre = nombre;
        subsidio = ThreadLocalRandom.current().nextDouble(MINIMO, MAXSUBSI);
    }
    
    @Override
    public double cobrar() {
        return subsidio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("Me llamo %s y soy un Parado. Cobro %.2f €", nombre, subsidio);
    }
    
    
    
}

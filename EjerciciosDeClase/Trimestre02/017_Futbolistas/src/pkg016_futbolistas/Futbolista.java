package pkg016_futbolistas;

public class Futbolista extends Persona{
    private int dorsal;
    private Posicion posicion;
    private int resistencia;
    private int lesiones;
    private int goles;
    
    public Futbolista(String nombre, String apellido, String dni, int edad, int dorsal,
            Posicion posicion, int resistencia, int lesiones, int goles) {
        super(nombre, apellido, dni, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.resistencia = resistencia;
        this.lesiones = lesiones;
        this.goles = goles;
    }
    
    
    @Override
    public String rolEnEquipo() {
        return "Futbolista";
    }
    
    public void lesionarse(int nivel) {
        lesiones += nivel;
    }
    
    public void curarse(int nivel) {
        lesiones -= nivel;
        if (lesiones < 0) lesiones = 0;
    }
    
    public void entrenar(Entrenamiento tipo) {
        switch (tipo) {
            case CORRER:  resistencia += 5;
            case SALTAR:  resistencia += 3;
            case ESTIRAR: resistencia += 1;
        }
    }
    
    public void entrevistarse() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Goles: " + goles);
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getDorsal() {
        return dorsal;
    }
    
    
    
}

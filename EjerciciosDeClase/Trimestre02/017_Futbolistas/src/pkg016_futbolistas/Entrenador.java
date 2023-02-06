package pkg016_futbolistas;

public class Entrenador extends Persona {

    public final int OFENSIVO = 0;
    public final int EQUILIBRADO = 1;
    public final int DEFENSIVO = 2;
    
    private int estrategia;
    
    public Entrenador(String nombre, String apellido, String dni, int edad, int estrategia) {
        super(nombre, apellido, dni, edad);
        this.estrategia = estrategia;
    }
    
    
    @Override
    public String rolEnEquipo() {
        return "Entrenador";
    }
    
}

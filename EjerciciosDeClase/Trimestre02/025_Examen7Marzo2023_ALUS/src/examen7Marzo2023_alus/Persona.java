package examen7Marzo2023_alus;

public interface Persona {
    public static final int MAXNOMINA = 3200;
    public static final int MAXSUBSI = 1000;
    public static final int MAXFIJO = 800;
    public static final int MINIMO = 400;
    
    public abstract double cobrar();
}

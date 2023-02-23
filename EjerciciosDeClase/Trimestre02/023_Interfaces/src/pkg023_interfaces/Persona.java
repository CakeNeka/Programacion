package pkg023_interfaces;

/**
 * 
 * @author Diurno
 * Las interfaces solo contienen métodos abstractos.
 * (Todos los métodos son por defecto abstract)
 * 
 * Todos los atributos declarados en una interfaz son por defecto
 * public static final (en este caso altura máxima)
 */
public interface Persona {
    
    double alturaMaxima = 2.5;
    
    public void hablar();
    
    public void setNombre(String nombre);
    
    public String getNombre();
}

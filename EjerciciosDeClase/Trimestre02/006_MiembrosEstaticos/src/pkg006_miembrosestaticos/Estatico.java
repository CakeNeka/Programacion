package pkg006_miembrosestaticos;

/**
 *
 * @author Diurno
 *         09/01/2023
 */
public class Estatico {
    
    static String type = "Dios";
    String name;

    @Override
    public String toString() {
        return "name=" + name + "\ntipo=" + type;
    }
    
    
    public static String muestraEstaticos() {
        return type;
    }
    public Estatico(String name) {
        this.name = name;
    }
    
    
}

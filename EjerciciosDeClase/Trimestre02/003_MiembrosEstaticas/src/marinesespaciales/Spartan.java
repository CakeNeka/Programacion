package marinesespaciales;

/**
 *
 * @author Diurno
 */
public class Spartan {
    static int idGenerator;
    
    int id;
    String name;

    public Spartan(int id, String name) {
        this.id = idGenerator++;
        this.name = name;
    }
    
    
}

package pkg023_interfaces;

/**
 *
 * @author Diurno
 */
public class Astronauta implements Estudiante{

    private String nombre;
    private String ciudad;

    public Astronauta(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    
    
    
    @Override
    public void estudiar() {
        System.out.println("*estudia astrología*");
    }

    @Override
    public void hablar() {
        System.out.println("*habla ruso e inglés (poliglota)*");
    }

    public void volar(){
        System.out.println("A MARTE");
    }
    
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Persona t) {
        Astronauta other = (Astronauta) t;
        return nombre.compareTo(other.getNombre());
    }
    
}

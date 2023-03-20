package examen7Marzo2023_alus;

public abstract class Trabajador implements Persona {
     
    private String nombre;
     
    public Trabajador(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
//  public abstract double cobrar(); 

    @Override
    public String toString() {
        
        String nombreClase = this.getClass().getSimpleName();
        /* ESTO MAL
        if (this.getClass().equals(Funcionario.class)) {
            nombreClase = "Funcionario";
        } else if (this.getClass().equals(PorComision.class)){
            nombreClase = "Por Comision";
        }
        */
        return String.format("Me llamo %s y soy un %s. Cobro %.2f €", nombre, nombreClase, cobrar());
    }
    
}

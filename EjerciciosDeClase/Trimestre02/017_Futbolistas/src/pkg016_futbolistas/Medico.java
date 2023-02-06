package pkg016_futbolistas;

public class Medico extends Persona{
    
    private String titulación;
    

    public Medico(String titulación, String nombre, String apellido, String dni, int edad) {
        super(nombre, apellido, dni, edad);
        this.titulación = titulación;
    }

    @Override
    public String rolEnEquipo() {
        return "Médico";
    }
}

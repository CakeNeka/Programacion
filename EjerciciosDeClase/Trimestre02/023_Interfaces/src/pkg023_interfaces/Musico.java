package pkg023_interfaces;


public abstract class Musico implements Persona {
    private String nombre;

    
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Persona t){
       return nombre.compareTo(t.getNombre());
    }
    
    
    public abstract void tocarMusica();
    
}

package pkg023_interfaces;


public class Estrella extends Musico {

    private String nombre;
    private String tipoMusica;

    Estrella(String luisa, String maracena) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void tocarMusica() {
        System.out.println("soy estre lla de " + tipoMusica);
    }

    @Override
    public void hablar() {
       
    }

    @Override
    public void setNombre(String nombre) {
    }
    
    void irDeGira(){
        System.out.println("*se va de gira*");
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    
}

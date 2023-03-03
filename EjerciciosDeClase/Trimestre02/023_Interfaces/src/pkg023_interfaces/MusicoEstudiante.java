package pkg023_interfaces;

/**
 * 
 * Una clase puede implementar varias interfaces.
 */
public class MusicoEstudiante extends Musico implements Estudiante {

    
    @Override
    public void estudiar() {
        System.out.println("*estudia*");
    }

    @Override
    public void hablar() {
        System.out.println("*mal asunto*");
    }

    @Override
    public void tocarMusica() {
        System.out.println("*toca musica*");
    }    

    void conciertoUni() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

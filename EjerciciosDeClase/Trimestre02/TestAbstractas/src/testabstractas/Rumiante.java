package testabstractas;

/**
 * 
 * @author Diurno
 */
public final class Rumiante extends AnimalHerbivoro {
    public static final int numEstomagos = 4;

    @Override
    public void respirar() {
        System.out.println("Respira como rumieante");
    }

    @Override
    public String toString() {
        return "Rumiante" + super.toString();
    }

    @Override
    public void alimentarse() {
        System.out.println("Respira como rumieante");
    }
    
    
    
}

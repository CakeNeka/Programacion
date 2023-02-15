package pkg020_clasesabstractas;

/**
 * 
 * @author Diurno
 * Fecha:  15/02/2023
 */
public class Main {

    public static void main(String[] args) {
        SerVivo criatura = new AnimalCarnivoro();
        criatura.alimentarse();
        
        Animal herbivoro = new AnimalHerbivoro();
        herbivoro.alimentarse();
        
        Planta planta = new Planta();
        planta.alimentarse();
        

    }
    
}

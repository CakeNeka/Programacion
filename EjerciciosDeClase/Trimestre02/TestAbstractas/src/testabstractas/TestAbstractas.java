package testabstractas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rut
 * 
 * 20-02-2023
 * 21-02-2023
 */
public class TestAbstractas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//      SerVivo s = new SerVivo();
        Planta ortiga = new Planta();
        ortiga.alimentarse();
        
        AnimalCarnívoro leon = new AnimalCarnívoro();
        leon.alimentarse();
        
        AnimalHerbivoro cabra = new AnimalHerbivoro();
        cabra.alimentarse();
        
        cabra.morir();
        
        // Vamos a usar POLIMORFISMO
        // Un objeto de la superclase puede contener cualquier objeto de las subclases
        System.out.println("******** POLIMORFISMO ********");
        SerVivo cualquieraSV = new AnimalCarnívoro();
        Animal cualquierA = new AnimalHerbivoro();
        AnimalHerbivoro herbi = new AnimalHerbivoro();
        AnimalCarnívoro carne = new AnimalCarnívoro();
        
        // Esto se llama UPCASTING
        SerVivo planta = new Planta();
        
        // no se puede hacer 
//        AnimalCarnívoro cualquiera2 = new Animal();
        
        // GRACIAS POLIMORFISMO !!!!! 
        ArrayList<SerVivo> arcaNoe = new ArrayList<>();
        ArrayList<Animal> arca2 = new ArrayList<>();
        arcaNoe.add(cualquierA);
        arcaNoe.add(cualquieraSV);
        arcaNoe.add(herbi);
        arcaNoe.add(carne);
        arcaNoe.add(planta);
        arca2.add((Animal)cualquieraSV);
        
        for (Animal animal : arca2) {
            System.out.println(animal.getClass());
        }
        
        // ALUMNOS: ORDENAR EL ARRAYLIST POR EL ORDEN NATURAL (por nombre+especie)
        
        
        // ESTO SE LLAMA DOWNCASTING
        Planta plantita = (Planta) planta;
        
        
        // No puedo meter una calse hermana en otra
        // ARCA2 ES DE TIPO ANIMAL (hermana de Planta)
        // arca2.add((Planta) planta);
        /*  */
        // Esto no se puede hacer porque estoy intentado meter al padre
        // (que es una clase superior) dentro del hijo (que es una clase inferior)
        // arca2.add(cualquiera);
        
        for (SerVivo animal : arcaNoe) {
            System.out.println(animal.getClass());
            System.out.println(animal);
        }
        
        
        // Downcasting de cualquier ser vivo:
        SerVivo an = new AnimalHerbivoro() ;
        AnimalHerbivoro herbivoro = (AnimalHerbivoro) an;
        
        List<SerVivo> circo = new ArrayList<>();
        circo.add(new Rumiante());
        
        
    }
    
}

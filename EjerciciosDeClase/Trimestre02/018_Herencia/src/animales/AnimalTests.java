package animales;

import java.util.ArrayList;
import java.util.List;

public class AnimalTests {
    public static void main(String[] args) {
        Carnivore crn = new Carnivore("Lion", "Panthera Leo", 420.0f);
        Herbivore hrb = new Herbivore("Horse", "Equus ferus caballus", "Salchichas");
        Omnivore hugo = new Omnivore("hugo", "hugus sapiens", " ");
        
        List<Animal> animales = new ArrayList<>();
        animales.add(crn);
        animales.add(hrb);
        animales.add(hugo);
        for (Animal animal : animales) {
            animal.eat();
            System.out.println("");
        }
        
        System.out.println();
    }
}

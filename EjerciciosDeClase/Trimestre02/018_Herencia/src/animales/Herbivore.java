package animales;

/**
 * 
 * @author Diurno
 */
public class Herbivore extends Animal {
    
    public static final FoodType FEEDING = FoodType.PLANTS;
    private String provenanceFood;
    
    public Herbivore(String name, String species, String provenanceFood) {
        super(name, species);
        this.provenanceFood = provenanceFood;
    }

    @Override
    public void eat() {
        System.out.printf("%s ate %s", name, provenanceFood);
    }

    @Override
    public String toString() {
        return super.toString() + "Herbivores{" + "herbivoreField=" + provenanceFood + '}';
    }
    
    
    
}

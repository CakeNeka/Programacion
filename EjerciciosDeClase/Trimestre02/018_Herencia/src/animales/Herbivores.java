package animales;

public class Herbivores extends Animal {
    
    public static final FoodType FEEDING = FoodType.PLANTS;
    
    private String provenanceCountry;
    
    public Herbivores(String name, String species, String provenanceCountry) {
        super(name, species);
        this.provenanceCountry = provenanceCountry;
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public String toString() {
        return super.toString() + "Herbivores{" + "herbivoreField=" + provenanceCountry + '}';
    }
    
    
    
}

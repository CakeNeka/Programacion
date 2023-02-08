package animales;

public class Omnivores extends Animal {
    
    public static final FoodType FEEDING = FoodType.MEAT_AND_PLANTS;
    
    private String omnivoreField;
    
    public Omnivores(String name, String species, String omnivoreField) {
        super(name, species);
        this.omnivoreField = omnivoreField;
    }
    
    

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public String toString() {
        return super.toString() + "Omnivores{" + "omnivoreField=" + omnivoreField + '}';
    }
    
    
    
}

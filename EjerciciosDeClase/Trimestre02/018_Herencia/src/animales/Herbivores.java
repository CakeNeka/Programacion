package animales;

public class Herbivores extends Animal {
    
    public static final FoodType FEEDING = FoodType.PLANTS;
    
    private String herbivoreField;
    
    public Herbivores(String name, String species, String herbivoreField) {
        super(name, species);
        this.herbivoreField = herbivoreField;
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public String toString() {
        return super.toString() + "Herbivores{" + "herbivoreField=" + herbivoreField + '}';
    }
    
    
    
}

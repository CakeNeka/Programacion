package animales;

public class Carnivore extends Animal{

    private static final FoodType FEEDING = FoodType.MEAT;
    private float kilograms;
    
    public Carnivore(String name, String species, float kilograms) {
        super(name, species);
        this.kilograms = kilograms;
    }
    
    
    
    @Override
    public void eat() {
        System.out.printf("%s ate %.02f kilograms of %s", name, kilograms, FEEDING);
    }

    @Override
    public String toString() {
        return "Carnivore{" +"name=" + name + ", kilograms=" + kilograms + '}';
    }
}

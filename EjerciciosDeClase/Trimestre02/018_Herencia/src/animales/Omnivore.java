package animales;

public class Omnivore extends Animal {
    
    public static final FoodType FEEDING = FoodType.MEAT_AND_PLANTS;
    
    private String omnivoreField;
    
    public Omnivore(String name, String species, String omnivoreField) {
        super(name, species);
        this.omnivoreField = omnivoreField;
    }
    
    

    @Override
    public void eat() {
        System.out.println(name + "Ate");
        
    }

    @Override
    public String toString() {
        return super.toString() + "Omnivores{" + "omnivoreField=" + omnivoreField + '}';
    }
    
    
    
}

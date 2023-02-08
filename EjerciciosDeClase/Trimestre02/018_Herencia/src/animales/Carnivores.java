package animales;

public class Carnivores extends Animal{

    private String carnivoreField;
    
    public Carnivores(String name, String species, String carnivoreField) {
        super(name, species);
        this.carnivoreField = carnivoreField;
    }
    
    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public String toString() {
        return super.toString() + "Carnivores{" + "carnivoreField=" + carnivoreField + '}';
    }
    
    
}

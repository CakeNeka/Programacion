package animales;

public class AnimalTests {
    public static void main(String[] args) {
        Carnivores crn = new Carnivores("Lion", "Panthera Leo", "campo carnívoro");
        Herbivores hrb = new Herbivores("Horse", "Equus ferus caballus", "");
        Omnivores hugo = new Omnivores("hugo", "hugus sapiens", "");
        
        System.out.println(crn);
    }
}

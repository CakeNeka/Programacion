package game.elements;

public class Potion extends Entity {
    
    private int healing; 

    public Potion(int healing, Tile parent) {
        super(parent, "Potion   ");
        this.healing = healing;
    }
    
    
    
    @Override
    public String getSymbol() {
        return "P";
    }
    
}

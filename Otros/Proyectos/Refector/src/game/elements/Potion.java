package game.elements;

public class Potion extends Entity {

    public Potion(Tile parent) {
        super(parent);
    }
    
    @Override
    public String getSymbol() {
        return "P";
    }
    
}

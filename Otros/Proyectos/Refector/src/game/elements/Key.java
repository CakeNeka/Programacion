package game.elements;

public class Key extends Entity {

    static char keySymbol = 'K';
    
    private int code;
    
    public Key(Tile parent, int code) {
        super(parent);
        this.code = code;
    }

    @Override
    public String getSymbol() {
        return keySymbol + "";
    }
    
}

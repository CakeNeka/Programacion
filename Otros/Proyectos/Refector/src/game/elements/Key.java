package game.elements;

public class Key extends Entity {

    static char keySymbol = 'K';
    
    private int code;

    public Key(int code) {
        super(null, "Key");
        this.code = code;
    }
    
    
    public Key(Tile parent, int code) {
        super(parent, "Key");
        this.code = code;
    }

    @Override
    public String getSymbol() {
        return keySymbol + "";
    }

    public int getCode() {
        return code;
    }
    
    
}

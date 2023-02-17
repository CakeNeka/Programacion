package defector;

public class Wall extends Entity {
    private static final char WALL_CHAR = '#';
    
    
    public Wall(int row, int col, char ch, GamePanel parent) {
        super(row, col, WALL_CHAR, false, parent);
    }
    
}

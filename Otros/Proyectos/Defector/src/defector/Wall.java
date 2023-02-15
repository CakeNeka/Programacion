package defector;

public class Wall extends Entity {
    private static final char WALL_CHAR = '#';
    
    
    public Wall(int row, int col, char ch) {
        super(row, col, WALL_CHAR, false);
    }
    
}

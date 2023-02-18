package game.elements;

/**
 *
 * @author Neka
 */
public class Wall extends Tile {

    
    public Wall(int row, int col) {
        super(row, col);
    }
    
    
    @Override
    public boolean isTraversable() {
        return false;
    }

    @Override
    public void setText() {
        this.setText("#");
    }
    
}

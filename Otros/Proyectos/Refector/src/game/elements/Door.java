package game.elements;

/**
 *
 * @author Neka
 */
public class Door extends Tile{
    
    private boolean locked;
    private int code;
    private int pointsToLevel;
    
    public Door(int row, int col, boolean locked) {
        super(row, col);
        this.locked = locked;
        pointsToLevel = -1;
    }

    public Door(int row, int col, boolean locked, int code) {
        super(row, col);
        this.locked = locked;
        this.code = code;
        pointsToLevel = -1;
    }
    
    
    
    public Door(int row, int col, boolean locked, int code, int pointsToLevel) {
        super(row, col);
        this.locked = locked;
        this.code = code;
        this.pointsToLevel = pointsToLevel;
    }
    
    @Override
    public boolean isTraversable() {
        return !locked;
    }

    @Override
    public void setText() {
        if (locked)
            setText("|");
        else
            setText("!");
    }

    public boolean isLocked() {
        return locked;
    }
    
    public boolean tryUnlock(Key key) {
        if (key.getCode() == code) {
            locked = false;
            return true;
        }
        return false;
    }

    public int getCode() {
        return code;
    }
    
    
    
    
}

package game.elements;

/**
 *
 * @author Neka
 */
public class Floor extends Tile {
    
    private boolean isEnemy;
    private boolean isPlayer;
    private Entity item;
    
    public Floor(int row, int col) {
        super(row, col);
        item = null;
        isEnemy = false;
        isPlayer = false;
    }
    
    public Floor(int row, int col, Entity item) {
        super(row, col);
        this.item = item;
        item.setParent(this);
        isEnemy = false;
        isPlayer = false;
    }

    public Floor(int row, int col, boolean isEnemy, boolean isPlayer) {
        super(row, col);
        this.isEnemy = isEnemy;
        this.isPlayer = isPlayer;
        item = null;
    }
    
    @Override
    public boolean isTraversable() {
        return true;
    }

    @Override
    public void setText() {
        if (isEnemy)
            setText("M");
        else if (isPlayer)
            setText("@");
        else if (item != null)
            setText(item.getSymbol());
        else
            setText ("·");
    }
    
}

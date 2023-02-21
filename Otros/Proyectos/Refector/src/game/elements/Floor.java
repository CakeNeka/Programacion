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
        return !isEnemy && !isPlayer;
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

    public boolean isEnemy() {
        return isEnemy;
    }

    public void setEnemy(boolean isEnemy) {
        this.isEnemy = isEnemy;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    public Entity getItem() {
        return item;
    }

    public void setItem(Entity item) {
        this.item = item;
    }

    public boolean removeItem() {
        if (item == null) return false;
        
        item = null;
        return true;
    }
    
    
}

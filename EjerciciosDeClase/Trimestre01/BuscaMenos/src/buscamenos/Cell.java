package buscamenos;

public class Cell 
{    
    
    private Item item;
    private boolean traversable;
    private int row;
    private int col;

    public boolean isTraversable() { return traversable; }
    public void setTraversable(boolean traversable) { this.traversable = traversable; }
    
    
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public char getCellChar()
    {
        if(isPlayer())
            return '@';
        else if(isEnemy())
            return 'E';
        else if(!isTraversable())
            return '#';
        else if(item != null)
            return item.getCharacter();
        
        return '·';
    }
    
    public boolean isPlayer()
    {
        return this.row == Player.getInstance().getRow() && 
                this.col == Player.getInstance().getCol();
    }
    
    public boolean isEnemy()
    {
        if (Main.levelEnemies == null)
            return false;
        
        for (Enemy enemy : Main.levelEnemies) 
        {
            if(enemy.getRow() == row && enemy.getCol() == col)
                return true;
        }
        return false;
    }
    
    public Enemy returnEnemy()
    {
        if(isEnemy())
        {
            for (Enemy enemy : Main.levelEnemies) 
            {
                if(enemy.getRow() == row && enemy.getCol() == col)
                    return enemy;
            }
        }
        return null;
    }
    
    public Cell(boolean traversable, int row, int col) 
    {
        this.traversable = traversable;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() 
    {
        return Character.toString(getCellChar());
    }
    
}

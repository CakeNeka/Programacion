package buscamenos;

public class Enemy 
{
    private Player player = Player.getInstance();
    
    private int row;
    private int col;
    private int pow;
    private int hp;
    
    public Enemy(int row, int col, int pow, int hp) 
    {
        this.row = row;
        this.col = col;
        this.pow = pow;
        this.hp = hp;
    }
    
    public int getRow() { return row; }

    public int getCol() { return col; }
    
    public void followPlayer()
    {
        int rowMovement = player.getRow() - row;
        int colMovement = player.getCol() - col;
        
        // NORMALIZING MOVEMENT ( -2 -> -1 ; 3 -> 1 ; 0 -> 0)
        if (rowMovement != 0)
            rowMovement /= Math.abs(rowMovement);
        if (colMovement != 0)
            colMovement /= Math.abs(colMovement);
        
        move(rowMovement, colMovement);
    }
    
    public void move(int i, int j)
    {
        if (player.getRow() == row + i && player.getCol() == col + j)
        {
            player.receiveDamage(3);
        }
        else if (Main.curTable[row + i][col + j].isTraversable() 
                && !(Main.curTable[row + i][col + j] instanceof Gate))
        {
            row += i;
            col += j;
        }
    }
    
    public void receiveDamage(int damage)
    {
        hp -= damage;
        if (hp <= 0)
            destroy();
    }
    
    public void destroy()
    {
        System.out.println("Enemy killed");
        Main.levelEnemies.remove(this);
    }
}

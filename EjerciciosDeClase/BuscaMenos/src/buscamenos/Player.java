package buscamenos;

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    static Scanner scan = new Scanner(System.in);
    static private Player player;
    
    private int hp;
    private int maxHp;
    private ArrayList<Item> inventory;
    private int row;
    private int col;
    private Weapon weapon;
    
    
    
    public void move(int rowMovement, int colMovement)
    {
        if(Main.curTable[row+rowMovement][col+colMovement].isEnemy())
        {
            if (weapon != null)
                Main.curTable[row+rowMovement][col+colMovement].returnEnemy().receiveDamage(weapon.getPow());
        }
        else if(Main.curTable[row+rowMovement][col+colMovement] instanceof Gate)
        {
            Gate curGate = (Gate) Main.curTable[row+rowMovement][col+colMovement];
            openGate(rowMovement, colMovement);
            
            if (Main.curTable[row + rowMovement][col + colMovement].isTraversable())
            {
                row += rowMovement;
                col += colMovement;
                
                if (curGate.isEnd())
                {
                    teleport(curGate.getLevelPointer(), curGate.getRowTeleport(),
                            curGate.getColTeleport() );
                }
                   
            }
        }
        else if (Main.curTable[row + rowMovement][col + colMovement].isTraversable())
        {
            row += rowMovement;
            col += colMovement;
        }
    }
    
    private void openGate(int rowMovement, int colMovement)
    {
        Gate curGate = (Gate) Main.curTable[row+rowMovement][col+colMovement];
        int gateId = curGate.getGateId();
        
        if (!curGate.isTraversable())
        {

            int i = 0;
            boolean keyFound = false;
            while(i < inventory.size() && !keyFound)
            {
                if (inventory.get(i) instanceof Key)
                {
                    if(gateId == ((Key)inventory.get(i)).getKeyId())
                    {
                        curGate.open((Key)inventory.get(i));
                        inventory.remove(i);
                        keyFound = true;
                    }
                }
                i++;
            }
        }
        if (!curGate.isTraversable())
            System.out.println("None of your keys can open the gate");

    }

    public ArrayList<Item> getInventory() { return inventory; }    
    
    public int getRow() { return row; }

    public void setRow(int row) { this.row = row; }

    public int getCol() { return col; }

    public void setCol(int col) { this.col = col; }
    
    void displayInventory() 
    {
        System.out.printf("%s %20s |%d/%d|\n", "INVENTORY:", "HP",hp,maxHp); 
        for (int i = 0; i < inventory.size(); i++) 
        {
            if (inventory.get(i) != null)
                System.out.println((i+1) + "·" +inventory.get(i).getName());
        }
    }
    
    public void teleport(int levelIndex, int row, int col)
    {
        Main.changeTable(levelIndex);
        setRow(row);
        setCol(col);
    }
    
    public void receiveDamage(int damage)
    {
        hp -= damage;
        if (hp <= 0)
            Main.gameOver();
    }
    
    public void heal(int healing)
    {
        hp = hp + healing > maxHp ? maxHp : hp + healing;
    }
    
    public static Player getInstance()
    {
        if (player == null)
        {
            player = new Player(20, 1, 1);
        }
        return player;
    }
    
    private Player(int maxHp, int row, int col) 
    {
        this.maxHp = maxHp;
        this.hp = maxHp;
        
        this.inventory = new ArrayList<>();
        this.row = row;
        this.col = col;
    }

    public void updateWeapon() 
    { 
        int curWeaponPow;
        for (int i = 0; i < inventory.size(); i++) 
        {
            curWeaponPow = weapon == null ? 0 : weapon.getPow();
            
            if (inventory.get(i) instanceof Weapon)
            {
                if (((Weapon)inventory.get(i)).getPow() > curWeaponPow)
                {
                    weapon =((Weapon)inventory.get(i));
                }
            }
        }
        if (weapon != null)
            System.out.println(weapon.toString());
    }
    
    
}

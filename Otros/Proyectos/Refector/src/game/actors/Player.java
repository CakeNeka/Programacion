package game.actors;

import game.elements.Door;
import game.elements.Floor;
import game.gui.GameBoard;
import game.elements.Entity;
import game.elements.Key;
import game.elements.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neka
 */
public class Player extends Actor {

    static int MAX_HEALTH = 10;
    
    private List<Entity> inventory;
    
    public Player(int row, int col) {
        super(row, col);
        System.out.println("bulding player");
        inventory = new ArrayList<>();
    }

    @Override
    public void moveLeft() {
        if (GameBoard.tileAccesible(row, col - 1)) {
            changePosition(row, col - 1);
        }
    }

    @Override
    public void moveRight() {
        if (GameBoard.tileAccesible(row, col + 1)) {
           changePosition(row, col + 1);
        }
    }

    @Override
    public void moveUp() {
        if (GameBoard.tileAccesible(row - 1, col)) {
            changePosition(row - 1, col);
        }
    }

    @Override
    public void moveDown() {
        if (GameBoard.tileAccesible(row + 1, col)) {
            changePosition(row + 1, col);
        }
    }
    
    @Override
    public void attackLeft() {
        if (GameBoard.tileExists(row, col - 1))
            attack(row, col - 1);
    }

    @Override
    public void attackRight() {
        if (GameBoard.tileExists(row, col + 1))
            attack(row, col + 1);
    }

    @Override
    public void attackUp() {
        if (GameBoard.tileExists(row - 1, col))
            attack(row - 1, col);
    }

    @Override
    public void attackDown() {
        if (GameBoard.tileExists(row + 1, col))
            attack(row + 1, col);
    }
    
    @Override
    public void attack(int targetRow, int targetCol) {
        Tile targetTile = GameBoard.currentLevel[targetRow][targetCol];
        if (targetTile instanceof Door){
            tryOpenDoor(targetRow,targetCol);
        } else if (targetTile instanceof Floor && ((Floor)targetTile).isEnemy()) {
            
        }
    }
    
    private void tryOpenDoor(int row, int col){
        Door door = (Door) GameBoard.currentLevel[row][col];
        List<Key> keys = getKeys();
        int i = 0;
        while(i < keys.size() && door.isLocked()){
            door.tryUnlock(keys.get(i));
            i++;
        }
        
        for (Entity entity : inventory) {
            System.out.println(entity);
        }
        if (!door.isLocked()){
            inventory.remove(keys.get(i - 1));
        }
        for (Entity entity : inventory) {
            System.out.println(entity);
        }
    }
    
    private List<Key> getKeys(){
        List<Key> keys = new ArrayList<>();
        for (Entity entity : inventory) {
            if (entity instanceof Key) 
                keys.add((Key)entity);
        }
        return keys;
    }
    
    @Override
    protected void changePosition(int newRow, int newCol) {
        if (GameBoard.currentLevel[newRow][newCol] instanceof Door) {
            Door dr = (Door) GameBoard.currentLevel[newRow][newCol]; 
            newRow += newRow - row;
            newCol += newCol - col;
        }
        
        Floor currentFloor = (Floor) GameBoard.currentLevel[row][col];
        Floor newFloor = (Floor) GameBoard.currentLevel[newRow][newCol];
        currentFloor.setPlayer(false);
        newFloor.setPlayer(true);
        row = newRow;
        col = newCol;
        
        if (newFloor.getItem() != null) {
            takeItemFromCurrentTile();
        }
    }

    
    
    private void takeItemFromCurrentTile() {
        Floor currentFloor = (Floor)GameBoard.currentLevel[row][col];
        Entity item = currentFloor.getItem();
        currentFloor.removeItem();
        inventory.add(item);
        System.out.println("You found a " + item);
    }

 

}

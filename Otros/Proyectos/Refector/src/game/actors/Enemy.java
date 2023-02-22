package game.actors;

import game.elements.Door;
import game.elements.Floor;
import game.gui.GameBoard;

/**
 *
 * @author Neka
 */

public class Enemy extends Actor {

    public Enemy(int row, int col) {
        super(row, col);
    }

    @Override
    public void moveLeft() {
    
    }

    @Override
    public void moveRight() {
    
    }

    @Override
    public void moveUp() {
    
    }

    @Override
    public void moveDown() {
    
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
    }

    @Override
    public void attackLeft() {
    
    }

    @Override
    public void attackRight() {
    
    }

    @Override
    public void attackUp() {
    
    }

    @Override
    public void attackDown() {
    
    }

    @Override
    public void attack(int targetRow, int targetCol) {
        
    }
    
}

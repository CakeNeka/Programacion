package game.actors;

import game.elements.Door;
import game.elements.Floor;
import game.gui.GameBoard;

/**
 *
 * @author Neka
 */
public class Player extends Actor {

    public Player(int row, int col) {
        super(row, col);
        System.out.println("bulding player");
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
    protected void changePosition(int newRow, int newCol) {
        if (GameBoard.currentLevel[newRow][newCol] instanceof Door) {
            Door dr = (Door) GameBoard.currentLevel[newRow][newCol]; 
            newRow += newRow - row;
            newCol += newCol - col;
        }
        
        Floor curFl = (Floor) GameBoard.currentLevel[row][col];
        Floor newFl = (Floor) GameBoard.currentLevel[newRow][newCol];
        curFl.setPlayer(false);
        newFl.setPlayer(true);
        row = newRow;
        col = newCol;
        
    }

}

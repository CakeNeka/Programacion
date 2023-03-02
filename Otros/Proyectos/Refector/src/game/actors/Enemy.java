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
            return;
        }

        Floor currentFloor = (Floor) GameBoard.currentLevel[row][col];
        Floor newFloor = (Floor) GameBoard.currentLevel[newRow][newCol];
        currentFloor.setEnemy(false);
        newFloor.setEnemy(true);
        row = newRow;
        col = newCol;
    }

    public void autoMove() {
        Player curPlayer = GameBoard.player;
        int rowDifference = curPlayer.row - row;
        int colDifference = curPlayer.col - col;
        if (Math.abs(colDifference) > Math.abs(rowDifference)) {
            if (colDifference < 0) {
                moveLeft();
            } else if (colDifference > 0) {
                moveRight();
            }
        } else if (Math.abs(rowDifference) > Math.abs(colDifference)) {
            if (rowDifference < 0) {
                moveUp();
            } else if (rowDifference > 0) {
                moveDown();
            }
        }
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

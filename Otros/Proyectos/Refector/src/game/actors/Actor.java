package game.actors;

import game.gui.GameBoard;

/**
 * Actors move around the board
 *
 * @author Neka
 */
public abstract class Actor {

    private int row;
    private int col;

    public Actor(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void moveLeft() {
        if (GameBoard.positionAvailable(row, col - 1)) {

        }
    }

    public void moveRight() {
        if (GameBoard.positionAvailable(row, col + 1)) {

        }
    }

    public void moveUp() {
        if (GameBoard.positionAvailable(row, col + 1)) {

        }
    }

    public void moveDown() {
        if (GameBoard.positionAvailable(row, col + 1)) {

        }
    }
}

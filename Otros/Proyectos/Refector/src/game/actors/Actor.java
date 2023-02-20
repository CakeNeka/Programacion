package game.actors;

import game.gui.GameBoard;

/**
 * Actors move around the board
 *
 * @author Neka
 */
public abstract class Actor {

    protected int row;
    protected int col;
    
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

    public final void setCol(int col) {
        this.col = col;
    }

    public abstract void moveLeft();

    public abstract void moveRight();

    public abstract void moveUp();

    public abstract void moveDown();
    
    protected abstract void changePosition(int newRow, int newCol);
}

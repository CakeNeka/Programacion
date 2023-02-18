/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.elements;

/**
 *
 * @author Neka
 */
public class Door extends Tile{
    
    private boolean locked;
    private int code;
    private int pointsToLevel;
    
    public Door(int row, int col, boolean locked) {
        super(row, col);
        this.locked = locked;
        pointsToLevel = -1;
    }
    
    public Door(int row, int col, boolean locked, int pointsToLevel) {
        super(row, col);
        this.locked = locked;
        this.pointsToLevel = pointsToLevel;
    }
    
    @Override
    public boolean isTraversable() {
        return !locked;
    }

    @Override
    public void setText() {
        if (locked)
            setText("|");
        else
            setText("!");
    }

    public boolean isLocked() {
        return locked;
    }

    public void unLock(int codeKey) {
        if (codeKey == code) {
            locked = false;
        }
    }
    
    
}

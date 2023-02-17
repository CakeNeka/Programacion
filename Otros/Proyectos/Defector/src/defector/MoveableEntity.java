/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defector;

/**
 *
 * @author Diurno
 */
class MoveableEntity extends Entity{
    
    
    public MoveableEntity(int row, int col, char ch, boolean traversable, GamePanel parent) {
        super(row, col, ch, traversable, parent);
    }
    
    public void moveLeft(){
        if (parent.positionIsTraversable(row, col - 1))
            col = col - 1;
    }
    public void moveRight(){
        if (parent.positionIsTraversable(row, col + 1))
            col = col + 1;
    }
    public void moveUp(){
        if (parent.positionIsTraversable(row - 1, col))
            row = row - 1;
    }
    public void moveDown(){
        if (parent.positionIsTraversable(row + 1, col))
            row = row + 1;
    }
}

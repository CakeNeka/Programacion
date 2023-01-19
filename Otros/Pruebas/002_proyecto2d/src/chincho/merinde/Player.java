package chincho.merinde;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Player {
    
    Rectangle2D.Double sprite;
    
    
    static double baseVelocity = 2;
    static double size = 50;
    private Color color;
    
    private double xPos;
    private double yPos;
    
    public Player(double xPos, double yPos, Color color, MovementPanel parent) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        
        sprite = new Rectangle2D.Double(xPos, yPos, size, size);
    }
    
    public void draw(Graphics2D g2d) {
        sprite.setRect(xPos, yPos, size, size);
        
        g2d.setColor(color);
        g2d.fill(sprite);
    }
    
    public void moveLeft() {
        xPos -= baseVelocity;
    }
    
    public void moveRight() {
        xPos += baseVelocity;
    }
    
    public void shoot(int dir){
        Bullet b = new Bullet(xPos, yPos, dir);
        
    }
    
    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }
    
    
}

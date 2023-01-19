package chincho.merinde;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Bullet {
    
    Ellipse2D.Double sprite;
    
    static Color defaultColor = Color.YELLOW;
    static double size = 4;
    
    private double bulletOffsetx;
    private double bulletOffsety = 30;
    private double velocity = 5;
    
    double xPos;
    double yPos;
    int direction;
    
    public Bullet(double xPos, double yPos, int dir, Player parent) {
        this.xPos = xPos;
        this.yPos = yPos;
        
        bulletOffsetx = parent.size / 2;
        bulletOffsety *= dir;
        velocity *= dir;
        
    }
    
    public void draw(Graphics2D g2d) {
        sprite = new Ellipse2D.Double(xPos + bulletOffsetx, yPos + bulletOffsety, size, size);
        g2d.setColor(defaultColor);
        g2d.fill(sprite);
        
        yPos += velocity;
    }
}

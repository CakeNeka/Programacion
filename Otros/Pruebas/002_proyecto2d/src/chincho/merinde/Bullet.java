package chincho.merinde;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

public class Bullet {
    
    Ellipse2D.Double sprite;
    
    static Color defaultColor = Color.YELLOW;
    static double size = 4;
    private static double bulletOffset = 30;
    private static double velocity = 5;
    
    double xPos;
    double yPos;
    int direction;
    
    public Bullet(double xPos, double yPos, int dir) {
        this.xPos = xPos;
        this.yPos = yPos;
        
        bulletOffset *= dir;
    }
    
    public void draw(Graphics2D g2d) {
        sprite = new Ellipse2D.Double(xPos, yPos + bulletOffset, size, size);
        g2d.fill(sprite);
    }
}

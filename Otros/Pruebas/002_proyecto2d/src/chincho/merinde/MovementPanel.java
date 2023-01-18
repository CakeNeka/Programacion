package chincho.merinde;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

class MovementPanel extends JPanel{
    
    static int w = 640;
    static int h = 640;
    
    private int rectWidth = 50;
    private int rectHeight = 50;
    
    double upperRectx, upperRecty;
    double lowerRectx, lowerRecty;
    
    Rectangle2D.Double upperRect;
    Rectangle2D.Double lowerRect;
    Rectangle2D.Double background;
    MovementPanel() {
        upperRectx = w/2 - rectWidth/2;
        upperRecty = 0;
        
        lowerRectx = w/2 - rectWidth/2;
        lowerRecty = h - rectHeight;
        
        this.setPreferredSize(new Dimension(w,h));
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        w = this.getWidth();
        h = this.getHeight();
        
        upperRect = new Rectangle2D.Double(upperRectx, upperRecty, rectWidth, rectHeight);
        lowerRect = new Rectangle2D.Double(lowerRectx, lowerRecty, rectWidth, rectHeight);

        background = new Rectangle2D.Double(0,0,w,h);
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(new Color(5,5,5));
        g2d.fill(background);
        
        g2d.setColor(Color.RED);
        g2d.fill(upperRect);
        
        g2d.setColor(Color.BLUE);
        g2d.fill(lowerRect);
    }
}   

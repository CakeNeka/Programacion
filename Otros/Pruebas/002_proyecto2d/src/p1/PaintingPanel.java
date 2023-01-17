package p1;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

class PaintingPanel extends JComponent {
    
    int w = 640;
    int h = 640;
    
    double rectWidth = 125;
    
    double baseHeight = 125;
    double varHeight = 0;
    
    double  baseTopHeight = h * 0.5;
    double  varTopHeight = 0;
    
    
    PaintingPanel() {
        this.setPreferredSize(new Dimension(w, h));
    }

    @Override
    protected void paintComponent(Graphics g) {
        w = this.getWidth();
        h = this.getHeight();
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, w, h);
        
        g.setColor(Color.GREEN);
        g2d.fill(background);
        
        g.setColor(Color.BLUE);
        Rectangle2D.Double rect = new Rectangle2D.Double((w - rectWidth)/2,baseTopHeight - varTopHeight ,rectWidth, baseHeight + varHeight);
        g2d.fill(rect);
    }
}

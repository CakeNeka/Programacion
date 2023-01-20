package chincho.merinde;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

class MovementPanel extends JPanel {

    static int w = 640;
    static int h = 640;

    Player upper;
    Player lower;

    Rectangle2D.Double background;

    ArrayList<Bullet> bullets;

    MovementPanel() {
        bullets = new ArrayList<>();

        int upperRectx = w / 2 - (int) Player.size / 2;
        int upperRecty = 0;

        int lowerRectx = w / 2 - (int) Player.size / 2;
        int lowerRecty = h - (int) Player.size;

        upper = new Player(upperRectx, upperRecty, Color.RED, this);
        lower = new Player(lowerRectx, lowerRecty, Color.BLUE, this);
        
        this.setPreferredSize(new Dimension(w, h));
    }

    @Override
    public void paintComponent(Graphics g) {
        w = this.getWidth();
        h = this.getHeight();
        Graphics2D g2d = (Graphics2D) g;
        
        background = new Rectangle2D.Double(0, 0, w, h);
        g2d.setColor(new Color(5, 5, 5));
        g2d.fill(background);

        upper.draw(g2d);
        lower.draw(g2d);
        
        
        Iterator<Bullet> i = bullets.iterator();
        while (i.hasNext()){
            boolean impact = false;
            Bullet b = i.next();
            b.draw(g2d);
            if (b.getyPos() < upper.size && b.getxPos() > upper.getxPos() 
                    && b.getxPos() < upper.getxPos() + upper.size){ // Dentro de jugador de arriba
                upper.receiveDamage();
                impact = true;
            } else if (b.getyPos() > this.getHeight() - lower.size && b.getxPos() > lower.getxPos() 
                    && b.getxPos() < lower.getxPos() + lower.size){               // Dentro de jugador de abajo
                lower.receiveDamage();
                impact = true;
            }
            if (b.getyPos() < 0 || b.getyPos() > this.getHeight() || impact) {
                i.remove();
            }
        }
    }
    
    public void add(Bullet b) {
        bullets.add(b);
    }

}

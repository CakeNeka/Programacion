package chincho.merinde;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
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

        background = new Rectangle2D.Double(0, 0, w, h);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(5, 5, 5));
        g2d.fill(background);

        upper.draw(g2d);
        lower.draw(g2d);

        for (Bullet bullet : bullets) {
            bullet.draw(g2d);
        }
        /*
        g2d.setColor(Color.RED);
        g2d.fill(upperRect);
        
        g2d.setColor(Color.BLUE);
        g2d.fill(lowerRect);
         */

    }

}

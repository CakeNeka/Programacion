package chincho.merinde;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MainWindow extends JFrame {

    MovementPanel panel;
    Timer timer;
    int xSpeed = 2;
    InputListener input;

    MainWindow() {
        panel = new MovementPanel();
        timer = new Timer(1000 / 120, (ActionEvent ae) -> {
            update();
        });
        timer.start();
        input = new InputListener(this);

        this.add(panel);
        this.pack();
        this.setTitle("Senatus PopulusQue Romanus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(input);
        this.setVisible(true);
    }

    private void update() {
        checkMovementInputs();
        panel.repaint();
        
        for (Ellipse2D.Double bullet : panel.bullets) {
            //
        }
    }

    void checkMovementInputs() {

        if (input.pressedKeys.contains(KeyEvent.VK_A)) {
            moveUpperLeft();
        }
        if (input.pressedKeys.contains(KeyEvent.VK_D)) {
            moveUpperRight();
        }

        if (input.pressedKeys.contains(KeyEvent.VK_LEFT)) {
            moveLowerLeft();
        }
        if (input.pressedKeys.contains(KeyEvent.VK_RIGHT)) {
            moveLowerRight();
        }
        
        if(input.pressedKeys.contains(KeyEvent.VK_SPACE)) {
            
        }
    }

    void moveUpperLeft() {
        if (panel.upperRectx > 0)
            panel.upperRectx -= xSpeed;
    }

    void moveUpperRight() {
        if (panel.upperRectx < panel.getWidth() - panel.rectWidth)
            panel.upperRectx += xSpeed;
    }

    void moveLowerLeft() {
        if (panel.lowerRectx > 0)
        panel.lowerRectx -= xSpeed;
    }

    void moveLowerRight() {
        if (panel.lowerRectx < panel.getWidth() - panel.rectWidth)
            panel.lowerRectx += xSpeed;
    }
}

class InputListener implements KeyListener {

    // No permite elementos duplicados
    public Set<Integer> pressedKeys = new HashSet<>();
    MainWindow parent;

    InputListener(MainWindow parent) {
        this.parent = parent;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        checkInputs();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    private void checkInputs() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

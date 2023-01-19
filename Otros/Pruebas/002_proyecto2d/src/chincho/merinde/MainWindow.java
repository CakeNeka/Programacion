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
    }

    void checkMovementInputs() {
        
        // Upper player movement
        if (input.pressedKeys.contains(KeyEvent.VK_A)) {
            moveUpperLeft();
        }
        if (input.pressedKeys.contains(KeyEvent.VK_D)) {
            moveUpperRight();
        }
        if (input.pressedKeys.contains(KeyEvent.VK_S)) {
            panel.upper.shoot(1);
        }
        
        // Lower player movement
        if (input.pressedKeys.contains(KeyEvent.VK_LEFT)) {
            moveLowerLeft();
        }
        if (input.pressedKeys.contains(KeyEvent.VK_RIGHT)) {
            moveLowerRight();
        }
        if(input.pressedKeys.contains(KeyEvent.VK_UP)) {
            panel.lower.shoot(-1);
        }
    }

    void moveUpperLeft() {
        if (panel.upper.getxPos() > 0) {
            panel.upper.moveLeft();
        }
    }

    void moveUpperRight() {
        if (panel.upper.getxPos() < panel.getWidth() - Player.size) {
            panel.upper.moveRight();
        }
    }

    void moveLowerLeft() {
        if (panel.lower.getxPos() > 0) {
            panel.lower.moveLeft();
        }
    }

    void moveLowerRight() {
        if (panel.lower.getxPos() < panel.getWidth() - Player.size) {
            panel.lower.moveRight();
        }
    }
}

package defector;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MainWindow extends JFrame{
    GamePanel panel;
    Timer timer;

    MainWindow() {
        panel = new GamePanel();
        timer = new Timer(1000 / 120, (ActionEvent ae) -> {
            update();
        });
        timer.start();
        
        this.add(panel);
        this.pack();
        this.setTitle("Me parece que me vas a dar la pelota");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void update() {
        
    }
}

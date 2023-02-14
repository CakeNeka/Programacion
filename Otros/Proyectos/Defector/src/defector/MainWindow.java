package defector;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MainWindow extends JFrame{
    
    private final int timerPeriod = 1000;
    
    private GamePanel panel;
    private Timer timer;
    
    MainWindow() {
        panel = new GamePanel();
        timer = new Timer(timerPeriod, (ActionEvent ae) -> {
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

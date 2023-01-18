package chincho.merinde;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MainWindow extends JFrame{
    
    MovementPanel panel;
    Timer timer;
    
    MainWindow() {
        panel = new MovementPanel();
        timer = new Timer(1000 / 60 , (ActionEvent ae) -> {
            update();
        });
        timer.start();
        
        this.add(panel);
        this.pack();        
        this.setTitle("Senatus PopulusQue Romanus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new InputListener(this));
        this.setVisible(true);
    }
    
    private void update() {
        panel.repaint();
    }
}

class InputListener implements KeyListener {
    
    MainWindow parent;
    InputListener(MainWindow parent){
        this.parent = parent;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) { // 65 68  |  37 39
        if (ke.getKeyCode() == 65){
            parent.panel.upperRectx--;
        } 
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}

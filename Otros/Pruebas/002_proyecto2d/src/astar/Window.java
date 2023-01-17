package astar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Window extends JFrame {
    
    GridPanel grid;

    public Window() {
        this.setTitle("UwU");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid = new GridPanel(25,60);
        
        this.add(grid);
        this.pack();
                this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {}
            @Override
            public void keyPressed(KeyEvent ke) {}

            @Override
            public void keyReleased(KeyEvent ke) {
                int code = ke.getKeyCode();
                if (code == 32 || code == 10){
                    grid.search();
                }
            }
        });
        
        this.setVisible(true);
    }
}

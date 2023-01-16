package astar;

import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    
    GridPanel grid;

    public Window() {
        this.setTitle("UwU");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid = new GridPanel(25,60);
        
        this.add(grid);
        this.pack();
        this.setVisible(true);
    }
}

package game;

import game.gui.GameBoard;
import java.awt.BorderLayout;
import javax.swing.*;


public class Main {

 
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        
        window.add(new GameBoard(), BorderLayout.CENTER);
        window.add(new JLabel("texto"), BorderLayout.PAGE_END);
        window.pack();
        window.setVisible(true);
    }
    
}

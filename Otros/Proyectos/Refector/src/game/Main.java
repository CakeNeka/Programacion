package game;

import game.gui.GameBoard;
import javax.swing.JFrame;


public class Main {

 
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new GameBoard());
        window.pack();
        window.setVisible(true);
    }
    
}

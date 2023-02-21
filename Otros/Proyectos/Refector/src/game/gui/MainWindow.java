package game.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Diurno
 */
public class MainWindow extends JFrame {
    
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Me vas a dar la pelota");
        
        add(new GameBoard());
        add(new GameInfoPanel(), BorderLayout.PAGE_END);
//      add(new JLabel("texto"), BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }
}

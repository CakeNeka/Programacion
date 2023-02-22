package game.gui;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class GameInfoPanel extends JPanel{
   
    JLabel playerLabel;
    JLabel enemyLabel;
    JLabel enemiesLabel;
    JList inventory;
    
    public GameInfoPanel() {
        playerLabel = new JLabel("Player:");
        enemyLabel = new JLabel("Player:");
        enemiesLabel = new JLabel("Player:");
        inventory = new JList();
        
        add(playerLabel);
        add(enemyLabel);
        add(enemiesLabel);
        add(inventory);
        
    }
}

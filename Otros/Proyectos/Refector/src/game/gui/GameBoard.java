package game.gui;

import game.elements.Tile;
import game.utils.LevelReader;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * <h2> GameBoard </h2>
 * container for all objects in the game
 * @author Neka
 */
public class GameBoard extends JPanel implements KeyListener{
    
    static Tile[][] currentLevel = LevelReader.getLevel(1);;
//   static Player player;
    
    public GameBoard() {
        
        this.setLayout(new GridLayout(currentLevel.length, currentLevel[0].length, 0, 0));
        for (Tile[] tiles : currentLevel) {
            for (Tile tile : tiles) {
                this.add(tile);
                tile.setText();
            }
        }
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setVisible(true);
    }   

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package game.gui;

import game.actors.Enemy;
import game.actors.Player;
import game.elements.Floor;
import game.elements.Tile;
import game.utils.LevelReader;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * <h2> GameBoard </h2>
 * container for all objects in the game
 * @author Neka
 */
public class GameBoard extends JPanel implements KeyListener{
    
    static Tile[][] currentLevel = LevelReader.getLevel(1);;
    public static Player player;
    static List<Enemy> enemies = new ArrayList<>();

    public static boolean positionAvailable(int row, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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

    public static void initializePlayer(int row, int col){
        if (player == null) {
            player = new Player(row, col);
        } else {
            player.setRow(row);
            player.setCol(col);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
}

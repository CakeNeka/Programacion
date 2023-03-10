package game.gui;

import game.actors.Enemy;
import game.actors.Player;
import game.elements.Door;
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
 *
 * @author Neka
 */
public class GameBoard extends JPanel implements KeyListener {

    public static Tile[][] currentLevel;
    
    public static Player player;
    public static List<Enemy> enemies;

   


    public GameBoard() {
        enemies = new ArrayList<>();
        currentLevel = LevelReader.loadLevel(1);
        this.setLayout(new GridLayout(currentLevel.length, currentLevel[0].length, 0, 0));
        for (Tile[] tiles : currentLevel) {
            for (Tile tile : tiles) {
                this.add(tile);
            }
        }
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setVisible(true);
        
        repaintBoard();
    }
    
    void update() {
        for (Enemy enemy : enemies) {
            enemy.autoMove();
        }
        repaintBoard();
    }
    
    public static void initializePlayer(int row, int col) {
        if (player == null) {
            player = new Player(row, col);
        } else {
            player.setRow(row);
            player.setCol(col);
        }
    }

    public static boolean tileAccesible(int row, int col) {
        if (!tileExists(row,col)) {
            return false;
        }

        return currentLevel[row][col].isTraversable();
    }
    
    
    public static boolean tileExists(int row, int col) {
        return row >= 0 && row <= currentLevel.length && col >= 0 && col <= currentLevel[0].length;
    }
    
    public static void addEnemyAtPosition(int row, int col) {
        enemies.add(new Enemy(row,col));
    }
    public void repaintBoard() {
        for (Tile[] tiles : currentLevel) {
            for (Tile tile : tiles) {
                tile.setText();       
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                player.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                player.moveRight();
                break;
            case KeyEvent.VK_UP:
                player.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                player.moveDown();
                break;
            case KeyEvent.VK_D:
                player.attackRight();
                break;
            case KeyEvent.VK_A:
                
            default:
                break;
        }
        
        update();
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}

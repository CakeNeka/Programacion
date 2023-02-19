package game.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Neka
 */
public abstract class Tile extends JButton{
    
    public static final int TILE_SIZE = 30;
    private static final Font FONT = new Font(Font.DIALOG_INPUT,Font.PLAIN, 20);
    
    private final int row;
    private final int col;
    
    public Tile(int row, int col) { 
        this.row = row;
        this.col = col;
        
        this.setFont(FONT);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setBorder(null);
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
    }
    
    public abstract boolean isTraversable();
    
    public abstract void setText();

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    
}

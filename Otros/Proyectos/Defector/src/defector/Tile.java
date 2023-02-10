package defector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tile extends JButton{
    private int row;
    private int col;

    private char ch = 'd';
    
    public Tile(int row, int col, int width, int height) {  
        this.row = row;
        this.col = col;
        
        this.setBackground(Color.yellow);
        
        
        this.setText(ch + "");
        this.setPreferredSize(new Dimension(width, height));
        
    }
    
}

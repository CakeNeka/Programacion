package defector;

import java.awt.Dimension;
import javax.swing.JLabel;

public class Tile extends JLabel{
    private int row;
    private int col;

    private char ch = 'd';
    
    public Tile(int row, int col, int width, int height) {  
        this.row = row;
        this.col = col;
        
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);
        
        this.setText(ch + "");
        this.setPreferredSize(new Dimension(width, height));
        
    }
    
}

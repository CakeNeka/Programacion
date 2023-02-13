package defector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tile extends JButton{
    private int row;
    private int col;

    private char ch = '#';
    
    public Tile(int row, int col, int width, int height) {  
        this.row = row;
        this.col = col;
        
        Font fnt = new Font(Font.SERIF,Font.PLAIN, 20);
        this.setFont(fnt);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setBorder(null);
        this.setText(ch + "");
        this.setPreferredSize(new Dimension(width, height));
        
    }
    
}

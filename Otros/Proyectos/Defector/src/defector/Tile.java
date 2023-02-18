package defector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tile extends JButton{
    private final int row;
    private final int col;

    private char ch;
    
    public Tile(int row, int col, int width, int height) {  
        this.ch = '·';
        this.row = row;
        this.col = col;
        
        Font fnt = new Font(Font.DIALOG_INPUT,Font.PLAIN, 20);
        this.setFont(fnt);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setBorder(null);
        this.setFocusable(false);
        this.setText(ch + "");
        this.setPreferredSize(new Dimension(width, height));
        
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
        this.setText(ch + "");
    }
    
    
    
}

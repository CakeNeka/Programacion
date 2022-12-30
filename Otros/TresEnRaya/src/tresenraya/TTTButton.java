package tresenraya;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class TTTButton extends JButton implements ActionListener{
    final int row;
    final int col;
    Grid grid;
    char ch;
    
    TTTButton(int row, int col, Grid grid){
        this.row = row;
        this.col = col;
        this.grid = grid;
        
        this.setFocusable(false);
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.black, Color.black));
        this.addActionListener(this);
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Row " + row + " Col " + col);
        this.ch = grid.curChar;
        this.setText(Character.toString(ch));
        grid.checkForWin();
        grid.curChar = grid.curChar == 'X' ? 'O' : 'X';
    }
}

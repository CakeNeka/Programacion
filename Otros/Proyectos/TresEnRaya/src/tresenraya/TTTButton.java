package tresenraya;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class TTTButton extends JButton implements ActionListener {

    private int row;
    private int col;
    private Grid grid;
    private char ch;
    private boolean used;

    TTTButton(int row, int col, Grid grid) {
        used = false;
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
        if (!isUsed()) {
            setUsed(true);
            System.out.println("Row " + getRow() + " Col " + getCol());
            this.setCh(getGrid().curChar);
            this.setText(Character.toString(getCh()));
            getGrid().checkForWin();
            grid.curChar = getGrid().curChar == 'X' ? 'O' : 'X';
        }
        if (grid.gridComplete()){
            grid.restartGrid();
        }
    }

    
    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     * @return the ch
     */
    public char getCh() {
        return ch;
    }

    /**
     * @param ch the ch to set
     */
    public void setCh(char ch) {
        this.ch = ch;
    }

    /**
     * @return the used
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * @param used the used to set
     */
    public void setUsed(boolean used) {
        this.used = used;
    }
}

package buscaminas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class BoxButton extends JButton implements ActionListener {
    
    private Grid grid;
    private int row;
    private int col;
    private boolean discovered;
    private boolean mine;
    private int around;

    BoxButton(Grid grid, int row, int col) {
        discovered = false;
        mine = false;
        around = 0;
        
        this.grid = grid;
        this.row = row;
        this.col = col;

        this.setPreferredSize(new Dimension(50, 50));
        this.addActionListener(this);
    }

    
    public void updateButton() {
        if (isDiscovered()) {
            // Change color and display number when discovered

            //this.setBackground(Color.white);
            //this.setText(getAround() + "");
        }
    }

    // Cambiar esto por MouseListener
    @Override
    public void actionPerformed(ActionEvent ae) {
        grid.unCover(row, col);
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public int getAround() {
        return around;
    }

    public void setAround(int around) {
        this.around = around;
    }
    
    
}

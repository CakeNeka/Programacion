package buscaminas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

class BoxButton extends JButton implements MouseListener {

    private Grid grid;
    private int row;
    private int col;
    private Status status;
    private boolean mine;
    private int around;

    BoxButton(Grid grid, int row, int col) {
        status = Status.COVERED;
        mine = false;
        around = 0;

        this.grid = grid;
        this.row = row;
        this.col = col;

        // Look of the button
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.gray, Color.black));
        this.setPreferredSize(new Dimension(40, 40));
        this.setFocusable(false);
        this.addMouseListener(this);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == 1) {
            grid.click();
            if (grid.getClicks() == 1){
                grid.initializeMines(grid.mines, row, col);
            }
            this.unCover();
            grid.checkWin();
        } else if (me.getButton() == 3) {
            this.flag();
        }
    }

    public void unCover() {
        String text = this.getAround() == 0 ? "" : this.getAround() + "";
        if (this.isMine()) {
            BuscaMinas.gameOver();
        } else {
            this.setBackground(Color.white);
            this.setForeground(Color.BLACK);
            this.setText(text);
            this.setStatus(Status.DISCOVERED);
            grid.uncoverZeroes(row, col);
        }
    }

    public void flag() {
        if (status == Status.COVERED) {
            this.setStatus(Status.FLAGGED);
            this.setForeground(Color.red);
            this.setText("F");
        }
        else if (status == Status.FLAGGED){
            this.setStatus(Status.COVERED);
            this.setForeground(Color.black);
            this.setText("");
        }
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
        return status == Status.DISCOVERED;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}

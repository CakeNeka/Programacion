package buscaminas;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Grid extends JFrame {

    int rows;
    int cols;

    BoxButton[][] boxes;

    public Grid(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        boxes = new BoxButton[rows][cols];

        // Title and default close operation
        setTitle("Busca Pepos :)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols, 0, 0));

        // Add the Box Buttons to the panel
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boxes[i][j] = new BoxButton(this, i, j);
                panel.add(boxes[i][j]);
            }
        }

        // Add the panel to the frame
        add(panel);
        initializeMines(mines);
                
        // Set the size and display the frame
        pack();
        setVisible(true);
    }

    
    // Mejorable: 
    void initializeMines(int mines) {
        Random rand = new Random();
        int randRow;
        int randCol;

        do {
            randRow = rand.nextInt(rows);
            randCol = rand.nextInt(cols);

            if (!boxes[randRow][randCol].isMine()) {
                boxes[randRow][randCol].setMine(true);
                mines--;
            }

        } while (mines > 0);

        generateAround();
        updateButtons();
    }

    private void updateButtons() {
        int i = 0;
        int j = 0;
        while (i < rows) {
            boxes[i][j].updateButton();
            j++;
            if (j == cols) {
                j = 0;
                i++;
            }
        }
    }

    private void generateAround() {
        int i = 0;
        int j = 0;
        while (i < rows) {
            boxes[i][j].setAround(findAround(i,j));
            
            // Testing (should be removed)
            //boxes[i][j].setText(boxes[i][j].getAround() + "");
            
            j++;
            if (j == cols) {
                j = 0;
                i++;
            }
        }
    }
    
    private int findAround(int row, int col){
        if(boxes[row][col].isMine()) return -1;  // Not necessary
        
        int minesAround = 0;
        
        int startRow = row - 1;
        int startColumn = col - 1;
        
        if (row == 0)
            startRow = row;
        if (col == 0)
            startColumn = col;
        
        int i = startRow;
        int j = startColumn;
        while (i <= row + 1 && i < rows) {
            if (boxes[i][j].isMine()){
                minesAround++;
            }
            
            j++;
            if (j > col + 1 || j == cols) {
                j = startColumn;
                i++;
            }
        }
        
        return minesAround;
    }
    
    public void unCover(int row, int col) {
        String text = boxes[row][col].getAround() == 0 ? "" : boxes[row][col].getAround() + "";
        boxes[row][col].setBackground(Color.white);
        boxes[row][col].setText(text);
        boxes[row][col].setDiscovered(true);
        removeZeroes(row,col);
    }
    
    public void removeZeroes(int row, int col){
        if (boxes[row][col].getAround() != 0) return;
        
        boxes[row][col].setDiscovered(true);
        boxes[row][col].setBackground(Color.white);
        boxes[row][col].setText("");
        
        int i = row - 1;
        int startColumn = col - 1;
        
        if (row == 0)
            i = row;
        if (col == 0)
            startColumn = col;
        
        int j = startColumn;
        while (i <= row + 1 && i < rows) {
            
            if ((i != row || j != col) && !boxes[i][j].isDiscovered()){
                removeZeroes(i,j);
            }
            
            j++;
            if (j > col + 1 || j == cols) {
                j = startColumn;
                i++;
            }
        }
    }
}

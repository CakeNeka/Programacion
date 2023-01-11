package buscaminas;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Grid extends JFrame {

    final long timeStarted;
    final int rows;
    final int cols;
    final int mines;
    
    private int clicks;
    BoxButton[][] boxes;

    public Grid(int rows, int cols, int mines) {
        this.timeStarted = System.currentTimeMillis();
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        boxes = new BoxButton[rows][cols];

        // Title and default close operation
        setTitle("Busca Pepos :)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols, 0, 0));
        System.out.println();
        // Add the Box Buttons to the panel
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boxes[i][j] = new BoxButton(this, i, j);
                panel.add(boxes[i][j]);
            }
        }

        // Add the panel to the frame
        panel.setSize(BoxButton.BOX_WIDTH * cols, BoxButton.BOX_HEIGHT * rows);
        add(panel);

        // Set the size and display the frame
        pack();
        
        setVisible(true);
        
        
    }

    // Selecciona que casillas serán minas 
    public void initializeMines(int mines, int firstClickedRow, int firstClickedCol) {
        Random rand = new Random();
        int randRow;
        int randCol;

        do {
            randRow = rand.nextInt(rows);
            randCol = rand.nextInt(cols);

            if (!boxes[randRow][randCol].isMine() && (randRow != firstClickedRow || randCol != firstClickedCol)) {
                boxes[randRow][randCol].setMine(true);
                mines--;
            }

        } while (mines > 0);

        generateAround();
    }

    // Genera el número que corresponde a cada casilla 
    // (el número de minas que tiene a su alrededor)
    private void generateAround() {
        int i = 0;
        int j = 0;
        while (i < rows) {
            boxes[i][j].setAround(findAround(i, j));
//          boxes[i][j].setText(findAround(i,j) + "");
            
            j++;
            if (j == cols) {
                j = 0;
                i++;
            }
        }
    }
    private int findAround(int row, int col) {
        if (boxes[row][col].isMine())
            return - 1;
        int minesAround = 0;

        int startRow = row - 1;
        int startColumn = col - 1;

        if (row == 0) {
            startRow = row;
        }
        if (col == 0) {
            startColumn = col;
        }

        int i = startRow;
        int j = startColumn;
        while (i <= row + 1 && i < rows) {
            if (boxes[i][j].isMine()) {
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

    // Cuando se pulsa una casilla con numero 0 se descubren 
    // automáticamente las casillas que tiene a su alrededor
    public void uncoverZeroes(int row, int col) {
        BoxButton curButton = boxes[row][col];
        int around = curButton.getAround();
        curButton.setBackground(Color.white);
        curButton.setStatus(Status.DISCOVERED);

        if (around != 0) {
            curButton.setText(around + "");
            return;
        }

        curButton.setText("");

        int i = row - 1;
        int startColumn = col - 1;

        if (row == 0) {
            i = row;
        }
        if (col == 0) {
            startColumn = col;
        }

        int j = startColumn;

        // Looping through the boxes around the clicked box
        while (i <= row + 1 && i < rows) {

            if ((i != row || j != col) && !boxes[i][j].isDiscovered()) {
                uncoverZeroes(i, j);
            }

            j++;
            if (j > col + 1 || j == cols) {
                j = startColumn;
                i++;
            }
        }
    }

    public long getTimeAlive() {
        return (System.currentTimeMillis() - timeStarted);
    }

    public void checkWin() {
        if(searchWin()){
            BuscaMinas.winGame();
        }
    }
    
    // Comprueba que solo están cubiertas las casillas con mina
    private boolean searchWin() {

        int i = 0;
        int j = 0;
        while (i < rows) {
            
            if (!boxes[i][j].isDiscovered() && !boxes[i][j].isMine())
                return false;
            
            j++;
            if (j == cols) {
                j = 0;
                i++;
            }
        }

        return true;
    }
    
    
    public int getClicks() {
        return clicks;
    }
    
    // Cuenta la cantidad de clicks
    public void click() {
        this.clicks++;
    }
    
    
}

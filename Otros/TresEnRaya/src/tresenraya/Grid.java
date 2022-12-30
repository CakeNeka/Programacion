/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

/**
 *
 * @author Neka
 */
import java.awt.*;
import javax.swing.*;

public class Grid extends JFrame {

    TTTButton[][] buttonGrid;
    public char curChar = 'X';

    public Grid() {
        this.buttonGrid = new TTTButton[3][3];

        // title and default close operation
        setTitle("Tres Rayas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Panel to hold the buttons
        JPanel panel = new JPanel();

        // GridLayout with 3 rows and 3 columns
        panel.setLayout(new GridLayout(3, 3, 0, 0));

        // Create 9 custom buttons and add the buttons to the panel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonGrid[i][j] = new TTTButton(i, j, this);
                panel.add(buttonGrid[i][j]);
            }
        }

        // Add the panel to the frame
        add(panel);

        // Set the size and display the frame
        setSize(300, 300);
        setVisible(true);
    }

    public void checkForWin() {
        if (checkWins()) {
            JOptionPane.showConfirmDialog(this, curChar + " Ganó");
        }
    }

    public boolean checkWins() {
        boolean won = false;
        int i = 0;
        int j = 0;
        int matches = 0;

        // Check for horizontal wins
        while (!won && i < 3) {
            if (curChar == buttonGrid[i][j].ch) {
                matches++;
            }
            if (matches == 3) {
                won = true;
            }
            j++;
            if (j == 3) {
                i++;
                j = 0;
                matches = 0;
            }
        }

        // Check for vertical wins
        i = 0;
        while (!won && j < 3) {
            if (curChar == buttonGrid[i][j].ch) {
                matches++;
            }
            if (matches == 3) {
                won = true;
            }
            i++;
            if (i == 3) {
                j++;
                i = 0;
                matches = 0;
            }
        }

        // Check for descendent diagonal wins
        j = 0;
        while (!won && i < 3) {
            if (curChar == buttonGrid[i][j].ch) {
                matches++;
            }
            if (matches == 3) {
                won = true;
            }

            i++;
            j++;
        }

        // Check for ascendent diagonal wins
        i = 2;
        j = 0;
        matches = 0;
        while (!won && i >= 0) {
            if (curChar == buttonGrid[i][j].ch) {
                matches++;
            }
            if (matches == 3) {
                won = true;
            }

            i--;
            j++;
        }

        return won;
    }

}

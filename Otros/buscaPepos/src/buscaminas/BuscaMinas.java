package buscaminas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BuscaMinas {

    static Grid curGame;
    static int rows = 5;
    static int columns = 5;
    static int mines = 1;

    public static void main(String[] args) {
        curGame = new Grid(rows, columns, mines);
    }

    public static void gameOver() {
        curGame.setTitle("Busca Pepos :(");
        String[] opciones = {"Jogar d'nuovo", "Irsse daqui"};
        String time = String.format("%.2f segundos", (double)curGame.getTimeAlive() / 1000);
        int choice = JOptionPane.showOptionDialog(curGame, "Has perdidio estrepetiossamench\nHas invertido " + time, "Menuda decepción...",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (choice == 0) {
            curGame.dispose();
            curGame = new Grid(rows, columns, mines);
        } else {
            System.exit(0);
        }
    }
    
    public static void winGame(){
        String[] opciones = {"Jogar d'nuovo", "Irsse daqui"};
        String time = String.format("%.2f segundos", (double)curGame.getTimeAlive() / 1000);
        int choice = JOptionPane.showOptionDialog(curGame, "Felissitasions pelo suo triunfo\nHas invertido " + time, "Has ganado! (" + curGame.getClicks() + " clicks)",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (choice == 0) {
            curGame.dispose();
            curGame = new Grid(rows, columns, mines);
        } else {
            System.exit(0);
        }
    }
}

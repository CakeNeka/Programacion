package main;

import javax.swing.JOptionPane;


public class GameOver {
    static City city = City.getInstance();
    
    public static final int BANKRUPT = 0;
    public static final int DEPOPULATION = 1;
    
    public static void gameOver(int condition){
        if (condition == BANKRUPT) {
            JOptionPane.showMessageDialog(Main.menu, "You led " + city.getName() + " to bankrupt", "Game Over", JOptionPane.WARNING_MESSAGE);
            exit();
        }      
        else if (condition == DEPOPULATION) {
            JOptionPane.showMessageDialog(Main.menu, "All your citizens died, the empty city of " + city.getName() + " slowly turns to ashes", "Game Over", JOptionPane.WARNING_MESSAGE);
            exit();
        }
    }
    
    static void exit(){   
        System.exit(0);
    }
    
}

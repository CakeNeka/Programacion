package main;

import javax.swing.JOptionPane;

/**
* <h2>Game Over</h2>
* This class implements the different ways to end the game
* Is also used to test how JavaDoc Documentation works,
* so it is the only class with documentation!.
* <p>
* <b>Note:</b> Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
 * @author Martina Victoria
 * @version 0.0.1
 * @since 2022-12-15
 */
public class GameOver {
    static City city = City.getInstance();
    
    public static void checkForGameOver(){
        if (city.getMoney() < -1000){
            JOptionPane.showMessageDialog(Main.menu, "Tu ciudad está en bancarrota. Has perdido", "Game Over", JOptionPane.WARNING_MESSAGE);
            exit();
        }      
    }
    
    static void exit(){   
        System.exit(0);
    }
    
}

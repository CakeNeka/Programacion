package org.cakeneka.states;

import java.awt.Color;
import org.cakeneka.Adventure;

public class IntroState extends State {

    
    static final String message = "Juan: Buenos días";
    static final String[] initialOptions = {
        "Buenas noches",
        "Buenas tardes",
        "Buen día"
    };
    
    public IntroState(Adventure adventure) {
        super(adventure, initialOptions);
    }
    
    @Override
    public void nextState(int choice) {
        adventure.writeMessage(adventure.getPlayerName() + ": " + initialOptions[choice], Color.black);
        switch(choice) {
            case 1: 
            case 2:
            case 3:
                adventure.setState(new IntroState(adventure));
                break;
            default:
                break;
        }
        adventure.getState().showMessage();
    }

    @Override
    public void showMessage() {
        adventure.writeMessage(message, Color.gray);
    }
    
}

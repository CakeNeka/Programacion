package org.cakeneka.states;

import java.awt.Color;
import org.cakeneka.Adventure;

public class InitialState extends State {

    
    static final String message = "Bienvenida";
    static final String[] initialOptions = {
        "Manzana",
        "Banana",
        "Tomate"
    };
    
    public InitialState(Adventure adventure) {
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

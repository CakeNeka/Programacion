package org.cakeneka.states;

import java.awt.Color;
import org.cakeneka.Actor;
import org.cakeneka.Adventure;

public class IntroState extends State {

    
    static final String message = "Juan: Buenos días";
    static final String[] initialOptions = {
        "Buenas noches",
        "Buenas tardes",
        "Buen día"
    };
    
    public IntroState(Adventure adventure) {
        super(adventure, message, initialOptions, Actor.juan);
    }
    
    @Override
    public void nextState(int choice) {
        switch(choice) {
            case 1: 
            case 2:
            case 3:
                adventure.setState(new IntroState(adventure));
                break;
            default:
                break;
        }
    }

    
}

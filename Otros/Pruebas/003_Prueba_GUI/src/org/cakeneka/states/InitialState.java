package org.cakeneka.states;


import org.cakeneka.Adventure;

public class InitialState extends State {

    static final String message = "Bienvenida";
    static final String[] initialOptions = {
        "Manzana",
        "Banana",
        "Tomate"
    };
    
    public InitialState(Adventure adventure) {
        super(adventure, message, initialOptions, null);
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

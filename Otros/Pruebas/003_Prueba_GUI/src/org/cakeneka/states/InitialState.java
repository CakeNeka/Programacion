package org.cakeneka.states;

import org.cakeneka.Adventure;

public class InitialState extends State {

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
        
    }
    
}

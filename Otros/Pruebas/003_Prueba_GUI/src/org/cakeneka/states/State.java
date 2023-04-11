package org.cakeneka.states;

import org.cakeneka.Adventure;

public abstract class State {
    
    protected Adventure adventure;
    protected String[] options;
    
    public State(Adventure adventure, String[] options) {
        this.adventure = adventure;
        this.options = options;
    }
    
    public abstract void nextState(int choice);

    public String[] getOptions() {
        return options;
    }
    
    
}

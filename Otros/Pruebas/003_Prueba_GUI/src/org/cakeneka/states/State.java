package org.cakeneka.states;

import org.cakeneka.Adventure;

public abstract class State {
    
    protected Adventure adventure;
    
    public State(Adventure adventure) {
        this.adventure = adventure;
    }
    
    public abstract void nextState(int choice);
}

package org.cakeneka.states;

import org.cakeneka.Adventure;

public class States {
    private final State c1State;

    public States(Adventure adventure) {
        this.c1State = new C1State(adventure);
    }
    
}

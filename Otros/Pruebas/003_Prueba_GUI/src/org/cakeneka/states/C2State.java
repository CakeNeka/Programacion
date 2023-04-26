package org.cakeneka.states;

import org.cakeneka.Actor;
import org.cakeneka.Actors;
import org.cakeneka.Adventure;

public class C2State extends State {

    static final String message = "Te encuentras en un vasto y desolado paisaje que se extiende hasta donde alcanza la vista. ";
    static final String[] initialOptions = {
        "Ir al norte",
        "Ir al este",
        "Ir al sur",
        "Ir al oeste",
        "No hacer nada"
    };

    public C2State(Adventure adventure) {
        super(adventure, message, initialOptions, Actors.narrator);
    }

    @Override
    public void nextState(int choice) {
        switch (choice) {
            case 0:
                adventure.setState(new C1State(adventure));
                break;
            case 1:
                break;
            case 2:
                break;
            case 4:
                adventure.setState(new C2State(adventure));
                break;
            default:
                break;
        }
    }

}

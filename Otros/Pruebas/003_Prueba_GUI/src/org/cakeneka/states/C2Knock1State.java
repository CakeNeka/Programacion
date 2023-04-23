/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cakeneka.states;

import org.cakeneka.Actor;
import org.cakeneka.Adventure;

/**
 *
 * @author Neka
 */
public class C2Knock1State extends State {

    static final String message = "shh Capitán!";
    static final String[] initialOptions = {
        "Volver"
    };

    public C2Knock1State(Adventure adventure) {
        super(adventure, message, initialOptions, Actor.juan);
    }

    @Override
    public void nextState(int choice) {
        switch (choice) {
            case 0:
                adventure.setState(new C1State(adventure));
                break;
            default:
                break;
        }
    }

}

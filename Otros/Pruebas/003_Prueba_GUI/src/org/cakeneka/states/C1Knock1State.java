/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cakeneka.states;

import org.cakeneka.Actor;
import org.cakeneka.Actors;
import org.cakeneka.Adventure;

/**
 *
 * @author Neka
 */
public class C1Knock1State extends State {

    static final String message = "shh Capitán!";
    static final String[] initialOptions = {
        "Volver",
        "¿Quien anda ahí?"
    };

    public C1Knock1State(Adventure adventure) {
        super(adventure, message, initialOptions, Actors.juan);
    }

    @Override
    public void nextState(int choice) {
        switch (choice) {
            case 0:
                adventure.setState(new C1State(adventure));
                break;
            case 1:
                adventure.setState(new C1Knock2State(adventure));
            default:
                break;
        }
    }

}

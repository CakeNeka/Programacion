/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cakeneka.states;

import java.awt.Color;
import org.cakeneka.Actor;
import org.cakeneka.Actors;
import org.cakeneka.Adventure;

/**
 *
 * @author Neka
 */
public class C1State extends State {

    static final String message = "Frente a tí se alza una imponente montaña. Una "
            + "puerta impide tu paso a lo que parece ser una cueva, quizá el hogar de un malvado pielverde. ";
    static final String[] initialOptions = {
        "Volver al sur",
        "Intentar abrir la puerta",
        "Llamar a la puerta"
    };

    public C1State(Adventure adventure) {
        super(adventure, message, initialOptions, Actors.narrator);
    }

    @Override
    public void nextState(int choice) {
        switch (choice) {
            case 0:
                adventure.setState(new C2State(adventure));
                break;
            case 1:
                adventure.writeMessage("Te resulta imposible abrir la puerta. \n", speaker.getColor());
                break;
            case 2:
                adventure.setState(new C1Knock1State(adventure));
                break;
            default:
                break;
        }
    }
    
    @Override
    public void manageOptions(int choice) {
        
    }
}

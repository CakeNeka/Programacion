package org.cakeneka.states;

import java.awt.Color;
import javax.swing.JOptionPane;
import org.cakeneka.Actor;
import org.cakeneka.Adventure;

public class IntroState extends State {

    static final String message = "Eres un Astartes, un guerrero de élite del Imperio, "
            + "en la Gran Cruzada liderada por el Emperador para conquistar la "
            + "galaxia. Tu misión es neutralizar a los Xenos. El terreno es desconocido. "
            + "Toda comunicación se ha perdido y no queda rastro de fuerzas imperiales. ";
    
    static final String[] initialOptions = {
        "Continuar",
        "Abandonar la misión",
    };

    public IntroState(Adventure adventure) {
        super(adventure, message, initialOptions, Actor.narrator);
    }

    @Override
    public void nextState(int choice) {
        switch (choice) {
            case 0:
                adventure.setState(new C2State(adventure));
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Decides abandonar la cruzada y dejar a tus leales hermanos a la deriva");
                System.exit(0);
                break;
            default:
                break;
        }
    }

}

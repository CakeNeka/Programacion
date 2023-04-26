package org.cakeneka.states;

import java.awt.Color;
import org.cakeneka.Actor;
import org.cakeneka.Adventure;

public abstract class State {
    
    protected Adventure adventure;
    protected String stateMessage;
    protected String[] dialogueOptions;
    protected Actor speaker;
    
    public State(Adventure adventure, String stateMessage, String[] dialogueOptions, Actor actor) {
        this.adventure = adventure;
        this.stateMessage = stateMessage;
        this.dialogueOptions = dialogueOptions;
        this.speaker = actor;
    }
    
    public abstract void nextState(int choice);
    
    public void manageOptions(int choice) {}
    
    public String[] getDialogueOptions() {
        return dialogueOptions;
    }

    public Actor getSpeaker() {
        return speaker;
    }
    
    public Color getActorColor() {
        return speaker.getColor();
    }

    
    public String getFullMessage() {
        return speaker.getDisplayName() + stateMessage + "\n";
    }

    public String getPlayerDialogue(int opt) {
        return adventure.getPlayerName() +": "+ dialogueOptions[opt];
    }
}

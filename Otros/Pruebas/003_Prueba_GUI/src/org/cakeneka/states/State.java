package org.cakeneka.states;

import org.cakeneka.Actor;
import org.cakeneka.Adventure;

public abstract class State {
    
    protected Adventure adventure;
    protected String sentence;
    protected String[] options;
    protected Actor actor;
    
    public State(Adventure adventure, String sentence,String[] options, Actor actor) {
        this.adventure = adventure;
        this.sentence = sentence;
        this.options = options;
        this.actor = actor;
    }
    
    public abstract void nextState(int choice);
 
    public String[] getOptions() {
        return options;
    }

    public Actor getActor() {
        return actor;
    }

    public String getSentence() {
        return sentence;
    }
    
    
}

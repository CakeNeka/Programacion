package org.cakeneka;

import java.awt.Color;
import org.cakeneka.states.*;

public class Adventure {
    private State state;
    private MainWindow mainWindow;
    private String playerName;
    
    public Adventure() {
        mainWindow = new MainWindow(this);
        state = new IntroState(this);
        playerName = "Garviel Loken";
    }
    
    public void start(){
        mainWindow.setVisible(true);
        mainWindow.updateOptions(state.getDialogueOptions());
        writeMessage(state.getFullMessage(), state.getActorColor());
    }
    
    public void onOptionChosen(int opt){
        writeMessage(state.getPlayerDialogue(opt), Color.black);
        state.nextState(opt);
        writeMessage(state.getFullMessage(), state.getActorColor());
        mainWindow.updateOptions(state.getDialogueOptions());
    }
    
    public void writeMessage(String message, Color color) {
        mainWindow.writeText(message, color);
    }
    
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    
}
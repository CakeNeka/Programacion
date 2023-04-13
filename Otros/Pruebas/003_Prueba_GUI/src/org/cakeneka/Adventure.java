package org.cakeneka;

import java.awt.Color;
import org.cakeneka.states.*;

public class Adventure {
    private State state;
    private MainWindow mainWindow;

    private String playerName;
    
    public Adventure() {
        mainWindow = new MainWindow(this);
        state = new InitialState(this);
        playerName = "defaultPlayerName";
    }
    
    public void start(){
        mainWindow.setVisible(true);
        mainWindow.updateOptions(state.getOptions());
    }
    
    public void onOptionChosen(int opt){
        writeMessage(playerName + ": " + state.getOptions()[opt], Color.black);
        state.nextState(opt);
        if (state.getActor() == null) {
            writeMessage(state.getSentence(), Color.GRAY);
        } else {
            writeMessage(state.getActor().getName()+ ": " + state.getSentence(), state.getActor().getColor());
        }
        mainWindow.updateOptions(state.getOptions());
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
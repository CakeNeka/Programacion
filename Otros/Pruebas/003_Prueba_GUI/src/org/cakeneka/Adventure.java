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
        state.nextState(opt);
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
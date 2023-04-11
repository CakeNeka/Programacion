package org.cakeneka;

import org.cakeneka.states.*;

public class Adventure {
    private State state;
    private MainWindow mainWindow;

    public Adventure() {
        mainWindow = new MainWindow(this);
        state = new InitialState(this);
    }
    
    public void start(){
        mainWindow.setVisible(true);
        mainWindow.updateOptions(state.getOptions());
    }
    
    public void onOptionChosen(int opt){
        state.nextState(opt);
        mainWindow.writeText("elegida opción " + opt);
        mainWindow.updateOptions(state.getOptions());
    }
}
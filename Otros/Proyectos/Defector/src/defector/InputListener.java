/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Neka
 */
public class InputListener implements KeyListener {

    private Player player;

    public InputListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                break;
            case KeyEvent.VK_RIGHT:
                break;
            case KeyEvent.VK_UP: 
                break;
            case KeyEvent.VK_DOWN:
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}

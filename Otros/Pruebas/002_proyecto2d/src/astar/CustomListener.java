package astar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CustomListener extends MouseAdapter {
    
    Node parent;

    public CustomListener(Node parent) {
        this.parent = parent;
    }
    
    @Override
    public void mousePressed(MouseEvent me){
        if (me.getButton() == MouseEvent.BUTTON1){
            Node.setButtonPressed(1);
            parent.setUnTraversable();
        } else if (me.getButton() == MouseEvent.BUTTON3){
            Node.setButtonPressed(3);
            parent.setTraversable();
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent me) {
        Node.setButtonPressed(0);
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
        if (Node.getButtonPressed() == 1){
            parent.setUnTraversable();
        } else if (Node.getButtonPressed() == 3){
            parent.setTraversable();
        }
    }
    
}
package astar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Node extends JButton {
    
    private static int buttonPressed = 0;
    
    static final int NODE_HEIGHT = 30;
    static final int NODE_WIDTH = 30;
    
    static final Color traversableColor = Color.GREEN;
    static final Color notTraversableColor = Color.BLUE;
    static final Color pathColor = Color.RED;
    static final Color visitedColor = Color.YELLOW;
    static final Color startColor = Color.PINK;
    static final Color endColor = Color.MAGENTA;
        
    public int gCost;  // Distancia al inicio
    public int hCost;  // Distancia al objetivo
    public int fCost;  // Suma
    public final int row;
    public final int col;
    
    private boolean traversable; 
    private boolean start;
    private boolean end;
    
    public Node(int row, int col) {
        this.row = row;
        this.col = col;
        traversable = true;
        start = false;
        end = false;
        
        this.setFont(new Font(Font.SANS_SERIF,Font.BOLD,8));
        this.setBackground(traversableColor);
        this.setSize(NODE_WIDTH, NODE_HEIGHT);
        this.setFocusable(false);
        
        CustomListener listener = new CustomListener(this);
        this.addMouseMotionListener(listener);
        this.addMouseListener(listener);
    }
    
    // Getters & Setters
    
    public void setUnTraversable() {
        if (traversable && !end && !start){
            traversable = false;
            this.setBackground(notTraversableColor);
        }
    }
    
    public void setTraversable(){
        if (!end && !start) {
            traversable = true;
            this.setBackground(traversableColor);
        }
    }

    public static int getButtonPressed() {
        return buttonPressed;
    }

    public static void setButtonPressed(int aButtonPressed) {
        buttonPressed = aButtonPressed;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isEnd() {
        return end;
    }
    
    public void setAsStart() {
        this.start = true;
        this.setBackground(startColor);
    }

    public void setAsEnd() {
        this.end = true;
        this.setBackground(endColor);
    }
    
    
}

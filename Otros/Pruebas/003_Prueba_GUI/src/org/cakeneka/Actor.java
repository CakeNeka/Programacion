package org.cakeneka;

import java.awt.Color;

public class Actor {
    
    public static Actor juan = new Actor("Juan", new Color(150,0,0)); 
    
    private String name;
    private Color color;

    public Actor(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
    
    
}

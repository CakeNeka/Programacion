package org.cakeneka;

import java.awt.Color;

public class Actor {
   
    
    private String name;
    private String displayName;
    private Color color;

    public Actor(String name,String displayName, Color color) {
        this.displayName = displayName;
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    
}

package org.cakeneka;

import java.awt.Color;

public class Actor {
    
    // TODO Mover a clase Actors
    public static Actor juan = new Actor("Juan Alberto", "Juan: ", new Color(150,0,0)); 
    public static Actor narrator = new Actor("Narrator", "", Color.gray);
    
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

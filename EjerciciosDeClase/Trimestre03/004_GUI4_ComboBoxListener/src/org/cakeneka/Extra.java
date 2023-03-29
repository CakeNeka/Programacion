package org.cakeneka;

public class Extra {
    
    private String name;
    private float cost;

    public Extra(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }
    
    public Extra(String name, String cost) {
        this.name = name;
        this.cost = Float.parseFloat(cost);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    
    
}

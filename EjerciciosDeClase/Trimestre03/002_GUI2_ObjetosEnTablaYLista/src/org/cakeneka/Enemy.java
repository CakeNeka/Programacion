package org.cakeneka;

class Enemy {
    private String name;
    private String weapon;
    private float dps;

    public Enemy() {
    }

    public Enemy(String name, String arma, float dps) {
        this.name = name;
        this.weapon = arma;
        this.dps = dps;
    }

    public Enemy(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public float getDps() {
        return dps;
    }
    
    public String getFormattedDps() {
        return String.format("%.2f", dps);
    }

    public void setDps(float dps) {
        this.dps = dps;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

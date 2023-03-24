package org.cakeneka;

class Enemy {
    private String name;
    private String weapon;
    private float dps;

    public Enemy() {
    }

    public Enemy(String nombre, String arma, float dps) {
        this.name = nombre;
        this.weapon = arma;
        this.dps = dps;
    }

    public Enemy(String name) {
        this.name = name;
    }
    
    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getArma() {
        return weapon;
    }

    public void setArma(String arma) {
        this.weapon = arma;
    }

    public float getDps() {
        return dps;
    }

    public void setDps(float dps) {
        this.dps = dps;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

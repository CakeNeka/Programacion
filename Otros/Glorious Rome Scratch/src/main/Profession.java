package main;

import java.util.ArrayList;
import java.util.List;

class Profession {

    static final Profession IDLER = new Profession("Idler", 5);
    static final Profession BARD = new Profession("Bard", 20, 0.7f, 1.33f, 2f);
    static final Profession MINER = new Profession("Miner", 15, 2.5f, 1.15f, 0.5f);
    static final Profession WAITER = new Profession("Waiter", 18, 1.25f,1.25f,1.25f);
    static final Profession PRIEST = new Profession("Priest", 33, 1f, 1.25f, 3f);
    static final Profession FARMER = new Profession("Farmer", 23, 1.15f, 1f, 1f);
    
    // Los granjeros produciran poco y cobrarán mucho. 
    // Tendrás que tener al menos un tercio de tu población como granjeros o empezarán a morir de hambre
    
    static final Profession SOLDIER = new Profession("Soldier", 25, 2.0f, 1f, 1f);

    static List<Profession> professions;

    private String name;
    private int baseSalary;

    private float strengthMod;
    private float dexterityMod;
    private float wisdomMod;

    public static List<Profession> getProfessions() {
        professions = new ArrayList<>();
        professions.add(IDLER);
        professions.add(BARD);
        professions.add(MINER);
        professions.add(WAITER);
        professions.add(PRIEST);
        professions.add(FARMER);

        return professions;
    }

    public String getName() {
        return name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public float getStrengthMod() {
        return strengthMod;
    }

    public float getWisdomMod() {
        return wisdomMod;
    }

    public float getDexterityMod() {
        return dexterityMod;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) (%.02f %.02f %.02f)", name, baseSalary, strengthMod, dexterityMod, wisdomMod);
    }

    // Constructor:
    private Profession(String name, int baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public Profession(String name, int baseSalary, float strengthMod, float dexterityMod, float wisdomMod) {
        this.name = name;
        this.baseSalary = baseSalary;

        this.strengthMod = strengthMod;
        this.wisdomMod = wisdomMod;
        this.dexterityMod = dexterityMod;
    }

}

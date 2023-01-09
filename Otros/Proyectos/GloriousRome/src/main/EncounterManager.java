package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EncounterManager {
    
    private static Random rand = new Random();
    
    private List<Soldier> allyForces;
    private List<Soldier> enemyForces;
    
    private int lastEncounter = 15;
    private boolean inCombat;
    

    
    private void enterCombat(){
        System.out.println("Entered Combat");
        inCombat = true;
        generateEnemies();
        allyForces = City.getInstance().getSoldiers();
    }
    
    private void endCombat() {
        lastEncounter = City.getInstance().getTurn();
        enemyForces.clear();
        allyForces.clear();
        
        inCombat = false;
    }
    
    public void manageCombat() {
        // Habría que hacer algo más interesante pero sirve de momento:
        
        City city = City.getInstance();
        if (getAllyStrength() == getEnemyStrength()){
            
        } else if (getAllyStrength() > getEnemyStrength()) {
            for (Soldier enemyForce : enemyForces) {
                // kill enemy
            }
        } else {
            for (Soldier allyForce : allyForces) {
                city.silentKillCitizen((city.getPopulation().indexOf(allyForce)));
            }
        }
        
        endCombat();
    }
    
    public void update(){
        double rand = Math.random();
        System.out.printf("%.2f / %d \n", rand, getEncounterChance());
        if (rand <= ((double)getEncounterChance() / 100.0) ){
            enterCombat();
        }
    }
    
    private void generateEnemies(){
        int num = City.getInstance().getSoldiersNum() + (rand.nextInt(5) - 2) ;
        for (int i = 0; i < num; i++) {
            enemyForces.add(new Soldier("Demon", i + "", Profession.SOLDIER, 
                    rand.nextInt(20) + 5, rand.nextInt(20), rand.nextInt(10)));
        }
    }
    
    
    private int getEncounterChance(){
        if (inCombat) return 0;
        System.out.println(City.getInstance().getTurn());
        return (City.getInstance().getTurn() - lastEncounter) * 5;
    }

    public List<Soldier> getAllies() {
        return allyForces;
    }

    public List<Soldier> getEnemies() {
        return enemyForces;
    }
    
    public int getAllySize(){
        return allyForces.size();
    }
    
    public int getEnemySize(){
        return enemyForces.size();
    }
    
    public int getAllyStrength(){
        int i = 0;
        for (Soldier s : allyForces) {
            i += s.getStrength();
        }
        return i;
    }

    public int getEnemyStrength(){
        int i = 0;
        for (Soldier s : enemyForces) {
            i += s.getStrength();
        }
        return i;
    }
    
    public boolean isInCombat() {
        return inCombat;
    }
    
    public EncounterManager(){
        allyForces = new ArrayList<>();
        enemyForces = new ArrayList<>();
    }
    
 
}

package progoles;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Player implements Serializable {
    
    public final long PLAYER_ID;
    
    private String name;
    private String nickName;
    private Map<Integer, Integer> seasonGoals;

    public Player(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
        PLAYER_ID = System.currentTimeMillis();         // Posiblemente desaconsejado
        seasonGoals = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public int getGoalsOnSeason(int season) {
        if (!seasonGoals.containsKey(season)){
            seasonGoals.put(season, 0);
        }
        
        return seasonGoals.get(season);
    }
    
    public void setGoalsOnSeason(int season, int goals) {
        seasonGoals.put(season, goals);
    }
    
    public void addGoalOnSeason(int season) {
        if (!seasonGoals.containsKey(season)){
            seasonGoals.put(season, 0);
        }
        seasonGoals.put(season, seasonGoals.get(season) + 1);
    }
    
    public void subtractGoalOnSeason(int season) {
        if (!seasonGoals.containsKey(season)){
            seasonGoals.put(season, 0);
        }
        seasonGoals.put(season, seasonGoals.get(season) - 1);
    }
    
    public int getTotalGoals(){
        int totalGoals = 0;
        for (Integer value : seasonGoals.values()) {
            totalGoals += value;
        }
        return totalGoals;
    }
    
    public Map<Integer, Integer> getSeasonGoals() {
        return seasonGoals;
    }

    public void setSeasonGoals(Map<Integer, Integer> seasonGoals) {
        this.seasonGoals = seasonGoals;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
}

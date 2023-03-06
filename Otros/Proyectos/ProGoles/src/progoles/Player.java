package progoles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements Serializable {
    
    public final long PLAYER_ID;
    
    private String name;
    private String nickName;
    private List<Integer> seasonGoals;          // TODO Cambiar por ArrayList

    public Player(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
        PLAYER_ID = System.currentTimeMillis();         // Posiblemente desaconsejado
        seasonGoals = new ArrayList<>();
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
        if (season >= seasonGoals.size()){
            seasonGoals.add(season, 0);
        }
        
        return seasonGoals.get(season);
    }
    
    public void setGoalsOnSeason(int season, int goals) {
        seasonGoals.set(season, goals);
    }
    
    public void addGoalOnSeason(int season) {
        if (season >= seasonGoals.size()){
            seasonGoals.add(season, 0);
        }
        seasonGoals.set(season, seasonGoals.get(season) + 1);
    }
    
    public void subtractGoalOnSeason(int season) {
        if (season >= seasonGoals.size()){
            seasonGoals.add(season, 0);
        }
        seasonGoals.set(season, seasonGoals.get(season) - 1);
    }
    
    public int getTotalGoals(){
        int totalGoals = 0;
        for (Integer value : seasonGoals) {
            totalGoals += value;
        }
        return totalGoals;
    }
    
    public List<Integer> getSeasonGoals() {
        return seasonGoals;
    }

    public void setSeasonGoals(List<Integer> seasonGoals) {
        this.seasonGoals = seasonGoals;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
    
}

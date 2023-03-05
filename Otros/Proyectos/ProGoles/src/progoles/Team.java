package progoles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable{
    
    public final long TEAM_ID;
    
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        TEAM_ID = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

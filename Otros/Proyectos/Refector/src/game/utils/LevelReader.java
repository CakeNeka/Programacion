package game.utils;

import game.elements.Tile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Transforms a .txt file into a level
 * 
 * @author Neka
 */
public class LevelReader {
    
    public static Tile[][] getLevel(int levelIndex){
        String[] strLevel = txtToStringArray(levelIndex);
        
  
        
        Tile[][] level = new Tile[strLevel.length][strLevel[0].length()];
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                level[i][j] = TileFactory.generate(strLevel[i].charAt(j), i, j);
            }
            
        }
        
        /*
        String[] levelData = getLevelData();
        for (String dataRow : levelData){
            String[] data = dataRow.split(",")
            char symbol = data[0]
            int p1 = data[1]
            int p2 = data[3]
        }

        */
        return level;
    }
    
    private static String[] txtToStringArray(int levelIndex){
        String levelFile = "src/resources/level" + levelIndex + ".txt";
        String[] strLevel = new String[0];
        
        try {
            strLevel = Files.readAllLines(Paths.get(levelFile)).toArray(new String[0]);
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        return strLevel;
    }
    
}

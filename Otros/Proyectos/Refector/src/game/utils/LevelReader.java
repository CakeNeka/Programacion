package game.utils;

import game.elements.Door;
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
    
    /**
     * 
     * 
     * @param levelIndex
     * @return The selected level, ready to be played.
     */
    public static Tile[][] loadLevel(int levelIndex){
        String[] strLevel = getLevelFromTxt(levelIndex);
        
        Tile[][] level = new Tile[strLevel.length][strLevel[0].length()];
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                level[i][j] = TileFactory.generate(strLevel[i].charAt(j), i, j);
            }   
        }
        
        
        String[] levelData = getLevelDataFromTxt(levelIndex);
        for (String dataRow : levelData){
            Tile newTile = null;
            String[] data = dataRow.split(",");
            
            char symbol = data[0].charAt(0);
            int row = Integer.parseInt(data[1].trim());
            int col = Integer.parseInt(data[2].trim());
            if (symbol == 'K'){
                int code = Integer.parseInt(data[3].trim());
                newTile = TileFactory.generateKeyTile(row, col, code);
            } else if (symbol == '!') {
                boolean locked = data[3].trim().equalsIgnoreCase("true");
                int code = Integer.parseInt(data[4].trim());
                int pointsToLevel = Integer.parseInt(data[5].trim());
                newTile = TileFactory.generateDoor(row, col, locked, code, pointsToLevel);
            } else if (symbol == 'M') {
                newTile = TileFactory.enemyFloor(row, col);
            }
            
            level[row][col] = newTile;
        }
        
        
        return level;
    }
    
    /**
     * Converts the .txt level file to a String array
     * @param levelIndex
     * @return 
     */
    private static String[] getLevelFromTxt(int levelIndex){
        String levelFile = "src/resources/level" + levelIndex + ".txt";
        String[] strLevel = new String[0];
        
        try {
            strLevel = Files.readAllLines(Paths.get(levelFile)).toArray(new String[0]);
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        return strLevel;
    }
    
    /**
     * Gets the level details (keys, doors, enemies) from the .csv file
     * @param levelIndex
     * @return 
     */
    private static String[] getLevelDataFromTxt(int levelIndex) {
        String levelFile = "src/resources/level" + levelIndex + ".csv";
        String[] levelData = new String[0];
        
        try {
            levelData = Files.readAllLines(Paths.get(levelFile)).toArray(new String[0]);
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        return levelData;
    }
    
}

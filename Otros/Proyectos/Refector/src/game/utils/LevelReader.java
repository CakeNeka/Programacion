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
    
    public static Tile[][] getLevel(int l){
        String fileName = "src/resources/level" + l + ".txt";
        String[] strLevel = new String[0];
        
        try {
          strLevel = Files.readAllLines(Paths.get(fileName)).toArray(new String[0]);
            for (String string : strLevel) {
                System.out.println(string);
            }
          
        } catch (IOException e) {
          e.printStackTrace();
        }
        
        Tile[][] level = new Tile[strLevel.length][strLevel[1].length()];
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                level[i][j] = TileFactory.generate(strLevel[i].charAt(j), i, j);
            }
        }
        return level;
    }
    
}

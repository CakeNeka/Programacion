package game.utils;

import game.elements.*;
import game.gui.GameBoard;

/**
 *
 * @author Neka
 */
class TileFactory {

    /**
     * Generates simple tiles based on a symbol and position.
     * 
     * @param symbol 
     * @param row
     * @param col
     * @return a Wall, Floor, open Door or Player Tile
     */
    static Tile generate(char symbol, int row, int col) {
        Tile tile = null;
        switch (symbol){
            case '#':
                tile = new Wall(row,col);
                break;
            case '!':
                tile = new Door(row, col, false);
                break;
            case 'P':
                // tile = new Floor(row, col, Entities.Potion); 
                break;
            case 'M':
                tile = enemyFloor(row, col);
                break;
            case '@':
                tile = playerFloor(row, col);
                break;
            default:
                tile = new Floor(row,col);
        }
        
        return tile;
    }    
    
    static Floor enemyFloor(int row, int col){
//      GameBoard.addEnemy(row, col);
        return new Floor(row, col, true, false);
    }
    
    static Floor playerFloor(int row, int col){
        GameBoard.initializePlayer(row,col);
        return new Floor(row, col, false, true);
    }
    
    static Floor generateKeyTile(int row, int col, int keyCode){
        return new Floor(row, col, new Key(keyCode));
    }
    
    static Door generateDoor(int row, int col, boolean locked, int code, int pointsToLevel) {
        return new Door(row, col, locked, code, pointsToLevel);
    }
    
}

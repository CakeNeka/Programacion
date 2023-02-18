package game.utils;

import game.elements.*;

/**
 *
 * @author Neka
 */
class TileFactory {

    static Tile generate(char symbol, int row, int col) {
        Tile tile = null;
        switch (symbol){
            case '#':
                tile = new Wall(row,col);
                break;
            case '!':
                tile = new Door(row, col, false);
                break;
            case '|':
                tile = new Door(row, col, true);
                break;
            case 'P':
                // tile = new Floor(row, col, Entities.potion); 
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
        
        if (Character.isDigit(symbol)){
            tile = new Door(row, col, false, symbol - 48);
        }
        
        return tile;
    }    
    
    static Floor enemyFloor(int row, int col){
        return new Floor(row, col, true, false);
    }
    
    static Floor playerFloor(int row, int col){
        return new Floor(row, col, false, true);
    }
}

package buscamenos;

import java.util.ArrayList;

public class Main {
    
    public static ArrayList<Cell[][]> levels = new ArrayList<>();
    public static ArrayList<ArrayList<Enemy>> worldEnemies = new ArrayList<>();
    public static ArrayList<Enemy> levelEnemies;
    static InputHandler keyHandler;
    
    public static Cell[][] curTable;
    static Player player = Player.getInstance();
    
    public static void main(String[] args) 
    {
        clearConsole();
        initializeTables();
        changeTable(0);
        keyHandler = new InputHandler();
        displayInfo();
    }
     
    static void displayInfo()
    {
        printTable();
        player.displayInventory();
    }
     
    public static void move(int i, int j)
    {
        clearConsole();
        player.move(i, j);
        moveEnemies();
        if (curTable[player.getRow()][player.getCol()].getItem() != null)
        {
            player.getInventory().add(curTable[player.getRow()][player.getCol()].getItem());
            curTable[player.getRow()][player.getCol()].setItem(null);
        }
        player.updateWeapon();
        displayInfo();
    }

    static void moveEnemies()
    {
        if(levelEnemies != null)
            for (Enemy enemy : levelEnemies)
                enemy.followPlayer();    
    }
    
    public static void changeTable(int level) 
    {
        if (levels.size()-1 >= level)
            curTable = levels.get(level);
        if(worldEnemies.size()-1 >= level) // Prevents IndexOutOfBoundsException
            levelEnemies = worldEnemies.get(level);
    }

    static void initializeTables()
    {
        // GENERATING SCENE 0
        Cell[][] table = new Cell[15][20];
        worldEnemies.add(new ArrayList<>());
        generateWalls(table);
        for (int i = 0; i < table[10].length; i++) 
        {
            table[10][i] = new Cell(false,10,i);
        }
        
        table[10][4] = new Gate(10,4,1);
        table[5][19] = new Gate(5,19,2,true,false,1,4,1);
        table[7][0] = new Gate(7,0,4,true,false,3,1,1);
        
        table[8][3].setItem(new Key("Llave 1", 1));
        table[13][13].setItem(new Key("Llave 2",2));
        table[13][11].setItem(new Key("Llave 3", 3));
        
        levels.add(table);
        
        // GENERATING SCENE 1
        worldEnemies.add(new ArrayList<>());
        table = new Cell[10][10];
        generateWalls(table);
        table[4][0] = new Gate(4,0,-1,true,true,0,5,18);
        table[0][5] = new Gate(0,5,3,true,false,2,18,5);
        worldEnemies.get(1).add(new Enemy(7,7,4,4));
        table[8][8].setItem(new Key("Llave 4",4));
        levels.add(table);
        
        //GENERATING SCENE 2
        worldEnemies.add(new ArrayList<>());
        table = new Cell[20][11];
        generateWalls(table);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < table[i].length; j++) 
            {
                if (i == 1)
                    table[i][j].setTraversable(false);
                else if (j < 4 || j > 6)
                    table[i][j].setTraversable(false);
            }
        }
        table[19][5] = new Gate(19,5,-1,true,true,1,1,5);
        table[3][5].setItem(Weapon.sword());
        levels.add(table);
        
        // GENERATING SCENE 3
        
    } 
    
    static void generateWalls(Cell[][] table)
    {
        for (int i = 0; i < table.length; i++) 
        {
            for (int j = 0; j < table[i].length; j++)
            {
                if(i == 0 || i == table.length - 1 || j == 0 || j == table[i].length - 1)
                    table[i][j] = new Cell(false, i, j);
                else
                    table[i][j] = new Cell(true, i, j);
            }
        }
    }
    
    static void printTable()
    {
        for (int i = 0; i < curTable.length; i++) 
        {
            for (int j = 0; j < curTable[i].length; j++) 
            {
                System.out.print(curTable[i][j].getCellChar() + " ");
            }
            System.out.println();
        }
    }
    
    static void clearConsole()
    {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void gameOver() 
    {
        System.exit(0);
    }
}

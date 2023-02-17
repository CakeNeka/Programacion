package defector;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    private int rows = 16;
    private int cols  = 30;
    private int rowHeight  = 30;
    private int colWidth = 30;
    
    private List<Entity> entities;
    private Tile[][] grid;
    private Player player;
    
    
    public GamePanel() {
        grid = new Tile[rows][cols];
        player = new Player(0,0,'@',this);
        entities = new ArrayList<>();
        entities.add(player);
        
        this.setLayout(new GridLayout(rows, cols, 0, 0));
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Tile(i, j, colWidth, rowHeight);
                this.add(grid[i][j]);
            }
        }
        
        this.setPreferredSize(new Dimension(cols * colWidth, rows * rowHeight));
        this.addKeyListener(new InputListener(player));
        
        showEntities();
    }   
    
    public void showEntities(){
        for (Entity entity : entities) {
            grid[entity.getRow()][entity.getCol()].setCh(entity.getCh());
        }
    }
    
    public boolean positionIsTraversable(int row, int col) {
        showEntities();
        boolean rowIsNull = row >= grid.length || row < 0;
        boolean colIsNull = col >= grid[0].length || col < 0;
        if (rowIsNull || colIsNull)
            return false;
        for (Entity entity : entities) {
            if(entity.getRow() == row && entity.getCol() == col && !entity.isTraversable())
                return false;
        }
        return true;
        
    }
}

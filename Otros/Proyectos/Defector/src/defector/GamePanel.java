package defector;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    private int rows = 5;
    private int cols  = 5;
    private int rowHeight  = 80;
    private int colWidth = 80;
    
    private Tile[][] grid;
    
    
    public GamePanel() {
        grid = new Tile[rows][cols];
        this.setLayout(new GridLayout(rows, cols, 0, 0));
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Tile(i, j, colWidth, rowHeight);
                this.add(grid[i][j]);
            }
        }
        
        this.setPreferredSize(new Dimension(cols * colWidth, rows * rowHeight));
    }
    
    
}

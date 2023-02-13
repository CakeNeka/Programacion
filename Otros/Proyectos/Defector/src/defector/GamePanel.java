package defector;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    private int rows = 16;
    private int cols  = 30;
    private int rowHeight  = 30;
    private int colWidth = 30;
    
    private Tile[][] grid;
    private Player player;
    
    public GamePanel() {
        grid = new Tile[rows][cols];
        player = new Player();
        
        this.setLayout(new GridLayout(rows, cols, 0, 0));
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Tile(i, j, colWidth, rowHeight);
                this.add(grid[i][j]);
            }
        }
        
        this.setPreferredSize(new Dimension(cols * colWidth, rows * rowHeight));
        this.addKeyListener(new InputListener(player));
    }   
}

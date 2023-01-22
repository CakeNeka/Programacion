package astar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javafx.scene.input.KeyCode;

public class GridPanel extends JPanel {

    final int ROWS;
    final int COLS;

    
    private Node[][] nodes;
    Node goalNode;
    Node startNode;
    Node currentNode;
    ArrayList<Node> openList = new ArrayList<>();
    ArrayList<Node> checkedList = new ArrayList<>();

    boolean goalReached = false;
    int step = 0;
    
    public GridPanel(int ROWS, int COLS) {
        this.ROWS = ROWS;
        this.COLS = COLS;
        nodes = new Node[ROWS][COLS];

        this.setLayout(new GridLayout(ROWS, COLS, 0, 0));
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                nodes[i][j] = new Node(i, j);
                this.add(nodes[i][j]);
            }
        }

        // Cambiar esto:
        startNode = nodes[12][5];
        startNode.setAsStart();
        currentNode = startNode;
        
        goalNode = nodes[12][55];
        goalNode.setAsEnd();
        //

        calculateCosts();
        
        this.setPreferredSize(new Dimension(Node.NODE_WIDTH * COLS, Node.NODE_HEIGHT * ROWS));

    }

    private void calculateCosts() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                getCost(nodes[i][j]);
            }
        }
    }

    private void getCost(Node node) {
        // GET G COST (distance from the start node)
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        //GET H COST (Distance from goal)
        xDistance = Math.abs(node.col - goalNode.col);
        yDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xDistance + yDistance;

        //GET F COST (total)
        node.fCost = node.gCost + node.hCost;

        //DISPLAY THE COST ON NODE
        if (node != startNode && node != goalNode) {
            node.setText("<html>" + node.fCost + "<br>" + node.gCost + "<br>" + node.hCost + "</html>");
        }
    }
    
    public void search() {
        System.out.println("Finding path...");
        while (!goalReached){
            System.out.println(step);
            int col = currentNode.col;
            int row = currentNode.row;
            
            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);
            
            // Open the up node
            if (row - 1 >= 0)
                openNode(nodes[row-1][col]);
            
            // Open the left node
            if (col - 1 >= 0)
                openNode(nodes[row][col-1]);
            
            // Open the down node
            if (row + 1 < ROWS)
                openNode(nodes[row+1][col]);
            
            // Open the right node
            if(col + 1 < COLS)
                openNode(nodes[row][col+1]);
            
            // Find the best node
            int bestNodeIndex = 0;
            int bestNodefCost = Integer.MAX_VALUE;
            
            for (int i = 0; i < openList.size(); i++) {
                if (openList.get(i).fCost < bestNodefCost){
                    bestNodefCost = openList.get(i).fCost;
                    bestNodeIndex = i;
                }
                else if (openList.get(i).fCost == bestNodefCost){
                    if (openList.get(i).gCost < openList.get(bestNodeIndex).gCost)
                        bestNodeIndex = i;
                }
            }
            
            currentNode = openList.get(bestNodeIndex);
            if (currentNode == goalNode){
                goalReached = true;
                trackThePath();
            }
            step++;
        }
    }
    
    private void trackThePath()
    {
        Node current = goalNode;
        while(current != startNode)
        {
            current = current.parent;
            if ( current != startNode )
            {
                current.setAsPath();
            }
        }
    }
    
    private void openNode(Node node){
        if (!node.isOpen() && !node.isChecked() && node.isTraversable()){
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }
    
}

package astar;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {

    final int ROWS;
    final int COLS;

    private Node[][] nodes;
    Node endNode;
    Node startNode;

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

        endNode = nodes[12][55];
        endNode.setAsEnd();
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
        xDistance = Math.abs(node.col - endNode.col);
        yDistance = Math.abs(node.row - endNode.row);
        node.hCost = xDistance + yDistance;

        //GET F COST (total)
        node.fCost = node.gCost + node.hCost;

        //DISPLAY THE COST ON NODE
        if (node != startNode && node != endNode) {
            node.setText("<html>" + node.fCost + "<br>" + node.gCost + "<br>" + node.hCost + "</html>");
        }
    }

}

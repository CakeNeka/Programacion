package prueba2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Prueba2 {

    public static void main(String[] args) {
        TreeNode binSearchTree = new TreeNode(100,
                new TreeNode(80,
                        new TreeNode(50,
                                new TreeNode(30),
                                new TreeNode(60)),
                        new TreeNode(90)),
                new TreeNode(120,
                        new TreeNode(110,
                                null,
                                new TreeNode(115)),
                        null));
        insertNode(binSearchTree, 108);
        printLeaveNodes(binSearchTree);
    }

    boolean TreeContains(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        return TreeContains(root.left, value) || TreeContains(root.right, value);
    }

    static TreeNode insertNode(TreeNode head, int value)   {
        if (head == null) {
            head = new TreeNode(value);
            return head;
        }
        if (value > head.val) {
            head.right = insertNode(head.right, value);
        } else {
            head.left = insertNode(head.left, value);
        }
        return head;
    }
    
    static void printLeaveNodes(TreeNode head) {
//      if (head == null) return;
        if(head.left == null && head.right == null){
            System.out.print(head.val + " ");
            return;
        }
        if (head.left != null) {
            printLeaveNodes(head.left);
        }
        if (head.right != null) {
            printLeaveNodes(head.right);
        }
    }
    
    // (Graph contains)
    static boolean depthFirstSearch(GraphNode node, Set<GraphNode> visited, int goal) {
        if (node == null) return false;
        if (node.val == goal) return true;
        
        for (GraphNode neighbour : node.neighbours) {
            if (!visited.contains(neighbour)){
                visited.add(neighbour);
                boolean found = depthFirstSearch(neighbour,visited,goal);
                if (found) return true;
            }
        }
        return false;
    }
    
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    static class GraphNode {
        
        int val;
        List<GraphNode> neighbours;
        
        public GraphNode(int val) {
            this.val = val;
            neighbours = new ArrayList<>();
        }
    }
}

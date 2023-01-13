package prueba2;

public class Prueba2 {

    public static void main(String[] args) {

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

    class TreeNode {

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
}

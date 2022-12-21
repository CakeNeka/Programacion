package pkg000_proyectoprueba;


public class Main {

    public static void main(String[] args) {
       Node a = new Node(0);
       Node b = new Node(1);
       Node c = new Node(2);
       Node d = new Node(3);
       a.next = b;
       b.next = c;
       c.next = d;
       
       printLinkedList(a);
       System.out.println("---");
       reverseLinkedList(a);
       System.out.println("---");
       printLinkedList(a);
    }
    
    static void reverseLinkedList(Node head){
        
        Node temp = head.next;
        head.next = null;
        
        while (temp != null){
            Node t = temp.next;
            temp.next = head;
            head = temp;
            temp = t;
        }
        
    }
    
    static void printLinkedList(Node root){
        System.out.println(root.val);
        while (root.next != null){
            root = root.next;
            System.out.println(root.val);
        }
    }
    
    static class Node{
        Node next;
        int val;
        
        Node(){}
        Node(int val){
            this.val = val;
        }
        Node(Node next, int val){
            this.next = next;
            this.val = val;
        }
    }
    
    static class TreeNode{
        
        TreeNode right;
        TreeNode left;
        int val;
        
        TreeNode(){}
        TreeNode(TreeNode left, TreeNode right, int val){
            this.left = left;
            this.right = right;
            this.val = val;
        }
        
        TreeNode(int val){
            this.val  = val;
        }
    }
}

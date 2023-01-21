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
        a = reverseList(a);
        System.out.println("---");
        printLinkedList(a);
    }

    static Node reverseLinkedList(Node head) {

        Node temp = head.next;
        head.next = null;

        while (temp != null) {
            Node t = temp.next;
            temp.next = head;
            head = temp;
            temp = t;
        }

        return head;

    }
    
    static Node mergeSortedLists(Node A, Node B){
        Node prehead = new Node();
        Node temp = prehead;
        
        while(A != null && B != null){
            if(A.val <= B.val){
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }
        while(A != null) {
            temp.next = A;
            temp = temp.next;
            A = A.next;
        }
        while(B != null) {
            temp.next = B;
            temp = temp.next;
            B = B.next;
        }
        return prehead.next;
    }
    
    static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    static void printLinkedList(Node root) {
        System.out.println(root.val);
        while (root.next != null) {
            root = root.next;
            System.out.println(root.val);
        }
    }

    static class Node {

        Node next;
        int val;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    static class TreeNode {

        TreeNode right;
        TreeNode left;
        int val;

        TreeNode() {
        }

        TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
}

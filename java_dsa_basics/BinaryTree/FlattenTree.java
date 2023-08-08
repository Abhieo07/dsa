package BinaryTree;

public class FlattenTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node a = new Node(4);
        Node b = new Node(8);
        root.left = a;
        root.right = b;
        Node c = new Node(11);
        Node d = new Node(7);
        a.left = c;
        c.left = d;
        Node e = new Node(13);
        Node f = new Node(2);
        b.left = e;
        c.right = f;
        Node g = new Node(4);
        Node h = new Node(5);
        Node i = new Node(1);
        b.right = g;
        g.left = h;
        g.right = i;
    }
}

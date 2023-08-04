package BinaryTree;

public class sizeMaxSum {

    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    static int height(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int size(Node root){
        if(root == null) return 0;
        int lSize = size(root.left);
        int rSize = size(root.right);
        return lSize + rSize + 1;
    }

    static int Max(Node root){
        if(root == null) return Integer.MIN_VALUE;
        int lmax = Max(root.left);
        int rmax = Max(root.right);
        return Math.max(root.val, Math.max(lmax, rmax));
    }

    static int sum(Node root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    static void preOrder(Node root){
        if(root == null) return;
        // size++;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        Node f = new Node(7);
        b.left = e;
        b.right = f;
        Node g = new Node(8);
        Node h = new Node(9);
        f.left = g;
        g.right = h;

        // preOrder(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(Max(root));
        System.out.println(height(root));

    }
}

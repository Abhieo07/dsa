package BinaryTree;

public class Zigzag {
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

    static void nthLevel(Node root, int n){ // left to right
        if(root == null) return;
        if(n == 1) {
            System.out.print(root.val+" ");
            return;
        }
        nthLevel(root.left,n - 1);
        nthLevel(root.right,n - 1);
    }
    
    static void nthLevel2(Node root, int n){ // right to left
        if(root == null) return;
        if(n == 1) {
            System.out.print(root.val+" ");
            return;
        }
        nthLevel2(root.right,n - 1);
        nthLevel2(root.left,n - 1);
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

        int level = height(root) + 1;
        for (int i = level; i > 0 ; i--) {
            if(i%2 == 0) nthLevel2(root,i);
            else nthLevel(root, i);
            System.out.println();
        }
    }
}

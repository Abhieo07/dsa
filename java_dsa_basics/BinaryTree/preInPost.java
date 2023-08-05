package BinaryTree;

public class preInPost {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }
    static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void InOrder(Node root){
        if(root == null) return;
        InOrder(root.left);
        System.out.print(root.val+" ");
        InOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    static void pip(int n){
        if(n==0)return;
        System.out.println("Pre "+n);//pre
        pip(n-1);
        System.out.println("In "+n); //In
        pip(n-1);
        System.out.println("Post "+n);//Post
    }

    static int height(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static void nthLevel(Node root, int n){
        if(root == null) return;
        if(n == 1) {
            System.out.print(root.val+" ");
            return;
        }
        nthLevel(root.left,n - 1);
        nthLevel(root.right,n - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(4);
        Node b = new Node(10);
        root.left = a;
        root.right = b;
        Node c = new Node(6);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(8);
        Node f = new Node(11);
        b.left = e;
        b.right = f;

        // System.out.println("Pre order traversel");
        // preOrder(root);
        // System.out.println("\nIn order traversel");
        // InOrder(root);
        // System.out.println("\nPost order traversel");
        // postOrder(root);

        // pip(3);

        int level = height(root) + 1;
        for (int i = 1; i <= level; i++) {
            nthLevel(root, i); //O(n)
            System.out.println();
        }
        // O(nlogn)
    }
}

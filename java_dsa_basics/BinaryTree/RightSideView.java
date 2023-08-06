package BinaryTree;

public class RightSideView {
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

    static void rightView(Node root, int level, int[] rs){
        if(root == null) return;
    
        rs[level-1] = root.val;
        level--;
        rightView(root.left, level, rs);
        rightView(root.right, level, rs);
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

        int level = height(root) + 1;
        int right[] = new int[level];
        rightView(root, level, right);
        for (int i : right) {
            System.out.print(i+" ");
        }

    }

}

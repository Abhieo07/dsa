package BinaryTree;

// Lowest Common Ancestors

public class LCA {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    static boolean contains(Node root, Node child){
        if(root == null) return false;
        if(root == child) return true;
        return contains(root.left, child) || contains(root.right, child);
    }

    static Node lowestCommonAncestor(Node root, Node child1, Node child2){
        if(child1 == root || child2 == root) return root;
        if(child1 == child2) return child1;
        boolean leftChild1 = contains(root.left, child1);
        boolean rightChild2 = contains(root.right, child2);
        if(leftChild1 && rightChild2 || !leftChild1 && !rightChild2) return root;
        if(leftChild1 && !rightChild2) return lowestCommonAncestor(root.left, child1, child2);
        if(!leftChild1 && rightChild2) return lowestCommonAncestor(root.right, child1, child2);
        return null;
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
        Node f = new Node(8);
        b.left = e;
        b.right = f;
        Node g = new Node(81);
        Node h = new Node(9);
        // f.left = g;
        // g.right = h;
        System.out.println(lowestCommonAncestor(root, g,h).val);
    }
}

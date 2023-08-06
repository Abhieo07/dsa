package BinaryTree;

// construct a tree using pre order and in order
public class TreeUsingPreIn {
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
    
    public static void main(String[] args) {
        int[] preOrder = {1,2,4,5,3,6};
        int[] inOrder = {4,2,5,1,3,6};
        Node root = constructTree(preOrder,0,preOrder.length-1, inOrder,0,inOrder.length-1);
        int level = height(root) + 1;
        for (int i = 1; i <= level ; i++) {
            nthLevel(root, i);
            System.out.println();
        }
    }

    private static Node constructTree(int[] preOrder, int prelo, int prehi, int[] inOrder, int inlo, int inhi) {
        if(prelo > prehi) return null;
        int rootval = preOrder[prelo];
        Node root = new Node(rootval);
        int i = inlo;
        while (inOrder[i] != preOrder[prelo]) i++;

        int leftSize = i - inlo;
        root.left = constructTree(preOrder, prelo+1, prelo+leftSize, inOrder, inlo, i-1);
        root.right = constructTree(preOrder, prelo+leftSize+1, prehi, inOrder, i+1, inhi);

        return root;
    }
}

package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class lcaBST {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    static Node constructBFS(String[] arr){
        Queue<Node> q = new LinkedList<>();
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;
        Node root = new Node(x);
        q.add(root);
        int i = 1;
        while (i < n - 1) {
            Node temp = q.remove();
            Node left = new Node(0);
            Node right = new Node(0);
            if(arr[i].equals("")) left = null;
            else{
                int l = Integer.parseInt(arr[i]);
                left.val = l;
                q.add(left);
            }
            if(arr[i + 1].equals("")) right = null; 
            else{
                int r = Integer.parseInt(arr[i + 1]);
                right.val = r;
                q.add(right);
            }
            temp.left = left;
            temp.right = right;
            i += 2;
            
        }
        return root;
    }
    public static void main(String[] args) {
        String[] arr = {"10","5","15","2","8","12","17"};
        Node root = constructBFS(arr);
        Node p = new Node(15);
        Node q = new Node(8);
        Node lca = lowestCommonAncestor(root, p, q);
        System.out.println("LCA: "+lca.val);
    }
    private static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(p.val == root.val || q.val == root.val) return root;
        else if(p.val < root.val && q.val > root.val) return root;
        else if(p.val > root.val && q.val < root.val) return root;
        else if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}

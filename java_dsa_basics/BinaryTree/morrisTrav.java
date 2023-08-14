package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class morrisTrav {
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
        System.out.println("Inorder traversal using Morris Traversal: ");
        morrisTraversalRev(root);
        System.out.println();
    }
    // Inorder traversal space: O(1)
    private static void morrisTraversal(Node root) {
        if(root == null) return;

        Node curr = root;
        while (curr != null) {
            if(curr.left != null){// find pred
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right == curr){
                    pred = null;
                    System.out.print(curr.val+" ");
                    curr = curr.right;
                }
            }else{
                System.out.print(curr.val+" ");
                curr = curr.right;
            }
        }
    }

    private static void morrisTraversalRev(Node root) {
        if(root == null) return;

        Node curr = root;
        while (curr != null) {
            if(curr.right != null){// find pred
                Node pred = curr.right;
                while (pred.left != null && pred.left != curr) {
                    pred = pred.left;
                }
                if(pred.left == null){
                    pred.left = curr;
                    curr = curr.right;
                }
                if(pred.left == curr){
                    pred = null;
                    System.out.print(curr.val+" ");
                    curr = curr.left;
                }
            }else{
                System.out.print(curr.val+" ");
                curr = curr.left;
            }
        }
    }
}

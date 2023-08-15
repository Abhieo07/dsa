package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class trimBST {
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
        int low = 8;
        int high = 15;
        Node curr = new Node(0);
        curr.left = root;
        trimBSTree(curr,low,high);
        System.out.println("After trimming "+low+" "+high+" :");
        morrisTrav(curr.left);
        System.out.println();
    }

    private static void morrisTrav(Node root) {
        Node curr = root;
        while (curr!=null) {
            if(curr.left!=null){
                Node pred = curr.left;
                while (pred.right!=null && pred.right!=curr) {
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

    private static void trimBSTree(Node root, int low, int high) {
        if(root == null) return;
        while(root.left!=null){
            if(root.left.val < low) root.left = root.left.right;
            else if(root.left.val > high) root.left = root.left.left;
            else break;
        }
        while(root.right!=null){
            if(root.right.val < low) root.right = root.right.right;
            else if(root.right.val > high) root.right = root.right.left;
            else break;
        }
        trimBSTree(root.left, low, high);
        trimBSTree(root.right, low, high);
    }
}

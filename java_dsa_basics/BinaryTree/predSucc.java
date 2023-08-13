package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class predSucc {
    static int pred = -1;
    static int succ = -1;
    static Node temp = null;
    static boolean flag = false;
    
    private static void inorder(Node root, int val) {
        if(root == null) return;
        inorder(root.left,val);
        if(root.val == val){
            pred = temp.val;
            flag = true;
        }else if(root.val > val && flag == true){
            succ = root.val;
            flag = false;
        }
        temp = root;
        inorder(root.right,val);
    }

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
        String[] a = {"10","5","15","2","8","12","17"};
        Node root = constructBFS(a);
        int val = 12;
        inorder(root,val);
        System.out.println("Pred is "+pred);
        System.out.println("Succ is "+succ);
    }
}

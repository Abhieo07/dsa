package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class deleteNode {
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

    private static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        String[] arr = {"50","20","60","17","34","55","89","10","","28","","","","70","","","14"};
        Node root = constructBFS(arr);
        preorder(root);
<<<<<<< HEAD
        int target = 20;
=======
        int target = 28;
>>>>>>> eaf18e4d924c5b860408b4c9e00002a4b6561292
        delete(root, target);
        System.out.println("\nAfter deletion");
        preorder(root);
    }

    private static void delete0(Node root, int target) {
        if(root == null) return;
        if(target < root.val){
            if(root.left == null) return;
            if(root.left.val == target)
            root.left = null;
            else delete0(root.left, target);
        }
        else{
            if(root.right == null) return;
            if(root.right.val == target)
            root.right = null;
            else delete0(root.right, target);
        }
    }

    private static void delete(Node root, int target) {
        if(root == null) return;
        if(target < root.val){
            if(root.left == null) return;
            if(root.left.val == target){
                Node l = root.left; // l is node that we wish to delete
                if(l.left == null && l.right == null) root.left = null; //0child
                else if(l.left == null || l.right == null) // 1 child
                    if(l.left != null) root.left = l.left;
                    else root.left = l.right;
<<<<<<< HEAD
                else{ // 2 child
                    Node curr = l;
                    Node pred = l.left;
                    while(pred.right != null) pred = pred.right;
                    delete(root, pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.left = pred;
                    
                }
=======
>>>>>>> eaf18e4d924c5b860408b4c9e00002a4b6561292
            }
            else delete(root.left, target);
        }
        else{
            if(root.right == null) return;
            if(root.right.val == target){
                Node l = root.right;
                if(l.left == null && l.right == null) root.right = null; //0child
                else if(l.left == null || l.right == null) // 1 child
                    if(l.left != null) root.right = l.left;
                    else root.right = l.right;
<<<<<<< HEAD
                else{ // 2 child
                    Node curr = l;
                    Node pred = l.left;
                    while(pred.right != null) pred = pred.right;
                    delete(root, pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.right = pred;
                    
                }
=======
>>>>>>> eaf18e4d924c5b860408b4c9e00002a4b6561292
            }
            else delete(root.right, target);
        }
    }

}

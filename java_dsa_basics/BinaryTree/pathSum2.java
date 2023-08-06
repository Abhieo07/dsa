package BinaryTree;

import java.util.ArrayList;
import java.util.List;


public class pathSum2 {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }


    private static void helper(List<List<Integer>> ans, List<Integer> arr,Node root, int sum){
        if(root == null) return;
        if(root.left == null && root.right == null){
            arr.add(root.val);
            if(sum == root.val){
                List<Integer> li = new ArrayList<>();
                for(int i = 0; i < arr.size(); i++){
                    li.add(arr.get(i));
                }
                ans.add(li);
            }
            arr.remove(arr.size()-1); //backtracing
        }
        arr.add(root.val);
        helper(ans, arr, root.left, sum-root.val);
        helper(ans, arr, root.right, sum-root.val);
        arr.remove(arr.size()-1); //backtracing

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node a = new Node(4);
        Node b = new Node(8);
        root.left = a;
        root.right = b;
        Node c = new Node(11);
        Node d = new Node(7);
        a.left = c;
        c.left = d;
        Node e = new Node(13);
        Node f = new Node(2);
        b.left = e;
        c.right = f;
        Node g = new Node(4);
        Node h = new Node(5);
        Node i = new Node(1);
        b.right = g;
        g.left = h;
        g.right = i;

        int targetSum = 22;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(ans,arr,root,targetSum);
        System.out.println(ans);
        
    }
}

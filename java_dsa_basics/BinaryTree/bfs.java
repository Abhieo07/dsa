package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    static void breadthFirstSearch(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root != null) q.add(root);
        while (q.size() > 0) {
            Node temp = q.peek();
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
            System.out.print(temp.val+" ");
            q.remove();
        }
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

        breadthFirstSearch(root);
    }
}

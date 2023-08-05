package BinaryTree;

import java.util.Stack;

public class dfs {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    static void depthFirstSearch(Node root){
        // inorder
        Stack<Node> st = new Stack<>();
        if(root!=null) st.push(root);
        while (st.size()>0) {
            Node temp = st.peek();
            if(temp.left != null){ 
                st.push(temp.left);
                temp.left = null; //vvip
            }
            else{ 
                st.pop();
                System.out.print(temp.val+" ");
                if(temp.right != null) {
                    st.push(temp.right);
                    temp.right = null;
                }
            }
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

        depthFirstSearch(root);
    }
}

package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class InfectionTime {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }

        static Node getNode(Node root, int start){
            if(root == null) return null;
            if(root.val == start) return root;
            Node leftTree =  getNode(root.left, start);
            Node rightTree =  getNode(root.right, start);
            if(leftTree == null) return rightTree;
            else return leftTree;
        }

        static void preorder(Node root, HashMap<Node, Node> p){
            if(root == null) return;
            if(root.left != null) p.put(root.left, root);
            if(root.right != null) p.put(root.right, root);
            preorder(root.left, p);
            preorder(root.right, p);
        }

        static int time(Node root, HashMap<Node, Node> parent){
            Node t = root;
            HashMap<Node, Integer> isVisited = new HashMap<>();
            Queue<Node> q = new LinkedList<>();
            q.add(t);
            isVisited.put(t, 0);
            while (q.size() > 0) {
                Node temp = q.remove();
                int level = isVisited.get(temp);
                if(temp.left != null && !isVisited.containsKey(temp.left)){
                    q.add(temp.left);
                    isVisited.put(temp.left, 1 + level);
                }
                if(temp.right != null && !isVisited.containsKey(temp.right)){
                    q.add(temp.right);
                    isVisited.put(temp.right, 1 + level);
                }
                if(parent.containsKey(temp)){
                    Node p = parent.get(temp);
                    if(!isVisited.containsKey(p)){
                        q.add(p);
                        isVisited.put(p, 1 + level);
                    }
                }
            }
            int val = 0;
            for (var value : isVisited.values()) {
                if(val < value) val = value;
            }
            return val;
        }

        public static void main(String[] args) {
            Node root = new Node(1);
            Node a = new Node(5);
            Node b = new Node(3);
            root.left = a;
            root.right = b;
            Node c = new Node(4);
            Node d = new Node(10);
            Node i = new Node(6);
            a.right = c;
            b.left = d;
            b.right = i;
            Node e = new Node(9);
            Node f = new Node(2);
            c.left = e;
            c.right = f;

            
            HashMap<Node, Node> parent = new HashMap<>();
            preorder(root, parent);

            int start = 3;
            Node node = getNode(root, start);
            System.out.println(time(node, parent));
            
        }
    }
}

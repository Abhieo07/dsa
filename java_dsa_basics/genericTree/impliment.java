package java_dsa_basics.genericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// import LinkedList.reverse;


class impliment{

    private static void formTree(Node root){
        root.child.add(new Node(5));
        root.child.add(new Node(11));
        root.child.add(new Node(63));

        root.child.get(0).child.add(new Node(1));
        root.child.get(0).child.add(new Node(4));
        root.child.get(0).child.add(new Node(8));

        root.child.get(1).child.add(new Node(6));
        root.child.get(1).child.add(new Node(7));
        root.child.get(1).child.add(new Node(15));

        root.child.get(2).child.add(new Node(31));
        root.child.get(2).child.add(new Node(55));
        root.child.get(2).child.add(new Node(65));
    }
    
    private static class Node {
        int val;
        List<Node> child;

        Node(int val){
            this.val = val;
            child = new ArrayList<>();
        }
    }

    private static void preOrder(Node root){
        if(root.child.isEmpty()) {
            System.out.print(root.val+" ");
            return;
        }
        System.out.print(root.val+" ");
        int i = 0;
        while (i < root.child.size()) {
            preOrder(root.child.get(i++));
        }
        
        return;
    }

    private static void postOrder(Node root){
        if(root.child.isEmpty()) {
            System.out.print(root.val+" ");
            return;
        }
        int i = 0;
        while (i < root.child.size()) {
            postOrder(root.child.get(i++));
        }
        System.out.print(root.val+" ");
        return;
    }

    private static void levelOrderTraversal(Node root){
        if(root.child.isEmpty()) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size()>0) {
            Node temp = q.remove();
            System.out.print(temp.val+" ");
            int i = 0;
            while(i < temp.child.size()){
                q.add(temp.child.get(i++));
            }
        }
    }

    private static void zigzagOrderTraversal(Node root){
        if(root.child.isEmpty()) return;
        boolean flag = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size()>0) {
            List<Node> currLevel = new ArrayList<>();
            int levelSize = q.size();
            while (levelSize-- > 0) {
                Node temp = q.remove();
                currLevel.add(temp);
                int i = 0;
                while(i < temp.child.size()){
                    q.add(temp.child.get(i++));
                }
            }
            if(!flag){
                for (int i = 0; i < currLevel.size(); i++) {
                    System.out.print(currLevel.get(i).val+" ");
                }
            }else{
                for (int i = 0; i < currLevel.size(); i++) {
                    System.out.print(currLevel.get(currLevel.size()-1-i).val+" ");
                }
            }
            flag = !flag;
        }
    }

    private static int finMax(Node root){
        if(root.child.isEmpty()) return root.val;
        int max = root.val;
        for (int i = 0; i < root.child.size(); i++) {
            int maxtill = finMax(root.child.get(i));
            if(maxtill > max) max = maxtill;
        }
        return max;
    }

    private static void mirrorTree(Node root){
        if(root.child.isEmpty()) return;
        int n = root.child.size();
        if(n== 1) return;

        for (int i = 0; i < n; i++) {
            mirrorTree(root.child.get(i));
            // reverse(root.child);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        formTree(root);
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrderTraversal(root);
        System.out.println();
        zigzagOrderTraversal(root);
        System.out.println();
        System.out.println("Maximum: "+ finMax(root));
    }
}
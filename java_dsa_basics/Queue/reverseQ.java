package Queue;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class reverseQ {
    static void reverseKEle(Queue<Integer> q, int k){
        Stack<Integer> st = new Stack<>();
        int n = q.size();
        while (q.size() >= 3) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }
        int i = 0;
        while(i < n - k){
            q.add(q.remove());
            i++;
        }
        System.out.println(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        q.add(1);
        q.add(2);
        q.add(5);
        q.add(7);
        q.add(9);
        System.out.println("Before");
        System.out.println(q);
        
        System.out.println("Reversed first k");
        reverseKEle(q, 3);

        while(q.size() != 0){
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }
        System.out.println("After reverse");
        System.out.println(q);

    }
}

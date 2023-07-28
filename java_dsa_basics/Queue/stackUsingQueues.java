package Queue;

import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueues {
    static Queue<Integer> q1 = new LinkedList<>();

    static void push(int val){
        q1.add(val);
    }

    static int peek(){
        for (int i = 0; i < q1.size() - 1; i++) {
            q1.add(q1.remove());
        }
        int x = q1.peek();
        q1.add(q1.remove());
        return x;
    }

    static int pop(){
        for (int i = 0; i < q1.size() - 1; i++) {
            q1.add(q1.remove());
        }
        return q1.remove();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            push(i);
        }
        System.out.println(q1);
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(q1);
    }
}

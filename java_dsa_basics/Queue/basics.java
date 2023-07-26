package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class basics {
    static void displayQueue(Queue<Integer> q){
        Queue<Integer> helper = new LinkedList<>();
        while (q.size() > 0) {
            System.out.print(q.peek()+" ");
            helper.add(q.poll());
        }
        while(helper.size() > 0) {
            q.add(helper.remove());
        }
        System.out.println();
    }

    static void displayRev(Queue<Integer> q){
        if(q.size() == 0){
            System.out.println();
            return;
        }
        int x = q.poll();
        displayRev(q);
        System.out.print(x+" ");
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        displayRev(q);
        // System.out.println(q);
        // q.remove();
        // System.out.println(q);
        // q.poll(); // queuefront
        // System.out.println(q);
    }
}

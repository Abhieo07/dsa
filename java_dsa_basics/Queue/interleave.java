package Queue;
import java.util.*;
import java.util.Queue;
/*
 * You are given a queue Q of N integers of even length,
 *  rearrange the elements by interleaving the first half 
 * of the queue with the second half of the queue.
 */

public class interleave {
    static Queue<Integer> interleaveHalfWithSecond(Queue<Integer> q, int n){
        Stack<Integer> st = new Stack<>();
        for (int index = 0; index < n / 2; index++) {
            st.push(q.remove()); //filling half the stack
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }
        while (q.size() > n/2) {
            st.push(q.remove()); //filling half the stack
        }
        while (st.size() > 0) {
            q.add(st.pop());
            q.add(q.remove());
        }
        while (q.size() > 0) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }

        return q;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        interleaveHalfWithSecond(q, n);
        System.out.println(q);
    }
}

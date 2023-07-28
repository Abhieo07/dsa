package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class deque {
    Deque<Integer> dq = new LinkedList<>();
    dq.addLast(1);
    dq.addLast(2);
    dq.addLast(3);
    dq.addLast(4);
    System.out.println(dq);
}

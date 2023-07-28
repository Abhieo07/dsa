package Queue;

import java.util.Stack;

public class queueWithStacks {
    static Stack<Integer> st1  = new Stack<>();
    static Stack<Integer> st2  = new Stack<>();

    static void add(int x){
        st1.push(x);
    }
    
    static int peek(){
        while (st1.size() > 1) {
            st2.push(st1.pop());
        }
        int val = st1.peek();
        while (st2.size() > 0) {
            st1.push(st2.pop());
        }
        return val;
    }

    static int remove(){
        while (st1.size() > 1) {
            st2.push(st1.pop());
        }
        int val = st1.pop();
        while (st2.size() > 0) {
            st1.push(st2.pop());
        }
        return val;
    }

    static boolean isEmpty(){
        if(st1.size() == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isEmpty());
        for (int i = 1; i < 5; i++) {
            add(i);
        }
        System.out.println(isEmpty());
        System.out.println(st1);
        System.out.println(peek());
        System.out.println(remove());
        System.out.println(remove());
        remove();
        remove();
        System.out.println(isEmpty());
        System.out.println(st1);
    }
}

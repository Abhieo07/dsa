package stack;
import java.util.Stack;

public class minStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();
    
    public minStack() {
        }
    
    public void push(int val) {
        if(st.size() == 0){
            st.push(val);
            min.push(val);
        }else {
            st.push(val);
            if(val < min.peek()){
                min.push(val);
            }else min.push(min.peek());
        }
    }
    
    public void pop() {
        st.pop();
        min.pop();
    }
    
    public int top() {
       return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

class MinStack {
    Stack<Long> st = new Stack<>();
    long min = -1;

    public MinStack() {
        }
    
    public void push(int val) {
        long x = (long) val;
        if(st.size() == 0){
            st.push(x);
            min = x;
        }else if(x >= min) st.push(x);
        else{
            st.push(2 * x - min);
            min = x;
        }
        
    }
    
    public void pop() {
        if(st.size() == 0) return;
        if(st.peek() >= min) st.pop();
        else if(st.peek() < min){
            long oldmin = 2 * min - st.peek();
            min = oldmin;
            st.pop();
        }

    }
    
    public int top() {
        long q = st.peek();
        if(st.size() == 0) return - 1;
        if(q >= min) return (int)q;
        if(q < min) return (int)min;
        return 0;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

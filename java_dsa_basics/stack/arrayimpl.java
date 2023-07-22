package stack;

public class arrayimpl {
    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println("Is Empty: "+st.isEmpty());
        st.push(4);
        st.push(3);
        st.push(5);
        st.display();
        st.pop();
        st.display();
        System.out.println("peek: "+st.peek());
        System.out.println("size: "+st.size());
        System.out.println("Is full: "+st.isFull());
        System.out.println("Is Empty: "+st.isEmpty());
        st.push(13);
        st.push(7);
        st.push(9);
        st.display();
        System.out.println("Is full: "+st.isFull());
        System.out.println("Capacity: "+ st.capacity());
        
    }
}

class Stack{
    private int[] arr = new int[50];
    private int idx = 0; //vvvip

    void push(int x){
        if(isFull()){
            System.out.println("Stack full");
            return;
        }
        arr[idx++] = x;
    }
    void display(){
        if(isEmpty()){
            System.out.println("Stack empty");
            return;
        }
        for (int i = 0; i < idx; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    int size() {return idx;}
    boolean isEmpty(){
        if(idx == 0) return true;
        else return false;
    }
    boolean isFull(){
        if(idx == arr.length) return true;
        else return false;
    }
    int capacity(){
        return arr.length;
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack empty");
            return Integer.MIN_VALUE;
        }
        return arr[idx-1];
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack empty");
            return Integer.MIN_VALUE;
        }
        int x = arr[--idx];
        arr[idx] = 0;
        return x;
    }
}

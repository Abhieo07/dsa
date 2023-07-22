package stack;

public class linkedlistimpl {
    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println("Is Empty: "+st.isEmpty());
        st.push(4);
        st.push(3);
        st.push(5);
        st.display();
        System.out.println("poped : "+st.pop());
        st.display();
        System.out.println("peek: "+st.peek());
        System.out.println("size: "+st.size());
        System.out.println("Is Empty: "+st.isEmpty());
        st.push(13);
        st.push(7);
        st.push(9);
        st.display();
    }
    
}
class Stack{
    private Node head = null;
    private int size = 0;

    void push(int x){
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }
    void display(){
        Node temp = head;
        displayR(temp);
        System.out.println();
    }
    void displayR(Node temp){
        if(temp == null) {
            return;
        }
        displayR(temp.next);
        System.out.print(temp.val+" ");
    }
    int pop(){
        if(head == null){
            System.out.println("Stack empty");
            return Integer.MIN_VALUE;
        }
        int top = head.val;
        head = head.next;
        size--;
        return top;
    }
    int peek(){
        if(head == null){
            System.out.println("Stack empty");
            return Integer.MIN_VALUE;
        }
        return head.val;
    }
    int size(){ //getter
        return size;
    }
    boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

}

class Node {
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

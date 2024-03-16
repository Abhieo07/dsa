import java.util.*;
class stack{
    static int size = 0;
    static Node head = null;
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void push(int data){
        Node newHead = new Node(data);
        if(isEmpty()){
            head = newHead;
            return;
        }
        this.size++;
        newHead.next = head;
        head = newHead;
    }
    
    public int pop(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        this.size--;
        int data = head.data;
        head = head.next;
        return data;
    }
    
    public int peek(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return head.data;
    }
    
    public int size(){
        return this.size;
    }
    
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class Main
{
    public static void pushAtBottom(stack s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    
    public static void reverseStack(stack s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }
    
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i<str.length()){
            s.push(str.charAt(i));
            i++;
        }
        StringBuilder rev = new StringBuilder("");
        while(s.size()>0){
            rev.append(s.pop());
        }
        return rev.toString();
    }
    
	public static void main(String[] args) {
		System.out.println("Testing stack implimentation using linked list");
		stack s = new stack();
		s.print();
		s.push(1);
		s.push(2);
// 		System.out.println("Size= "+s.size+ " top="+s.peek());
		s.push(3);
		s.print();
// 		System.out.println("Size= "+s.size+ " top="+s.peek());
// 		System.out.println(s.pop());
// 		s.print();
// 		System.out.println(s.pop());
// 		System.out.println("Size= "+s.size+ " top="+s.peek());
// 		s.print();
        pushAtBottom(s, 4);
        s.print();
        System.out.println("Reverse using stack: "+ reverseString("ABC"));
        reverseStack(s);
        s.print();
	}
}

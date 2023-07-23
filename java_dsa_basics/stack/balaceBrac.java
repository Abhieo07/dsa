package stack;

import java.util.Scanner;

public class balaceBrac {

    static boolean checkParenthesis(String bracs){
        Stack st = new Stack();
        for (int i = 0; i < bracs.length(); i++) {
            char bracket = bracs.charAt(i);
            if(bracket == '(' || bracket == '{' || bracket == '['){
                // push to stack
                st.push(bracket);
            }
            else if(bracket == ')' || bracket == '}' || bracket == ']'){
                // pop the top element if it is openening bracket 
                if(st.size() == 0) return false;
                if((st.peek() == '(' && bracket == ')') || (st.peek() == '{' && bracket == '}') || (st.peek() == '[' && bracket == ']'))
                    st.pop();
                else
                    return false;
            }

        }
        if(st.size() > 0) {
            System.out.println("remove "+st.size()+" brackets to make it balanced");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string of bracket");
        String bracs = sc.next();
        System.out.println("Is balanced Paranthesis: "+checkParenthesis(bracs));
    }
    
}

class Stack{
    private Node head = null;
    private int size = 0;

    void push(char x){
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }
    char pop(){
        if(head == null){
            System.out.println("Stack empty");
            return ' ';
        }
        char top = head.val;
        head = head.next;
        size--;
        return top;
    }
    char peek(){
        if(head == null){
            System.out.println("Stack empty");
            return ' ';
        }
        return head.val;
    }
    int size(){ //getter
        return size;
    }
}

class Node {
    char val;
    Node next;
    Node(char val){
        this.val = val;
    }
}

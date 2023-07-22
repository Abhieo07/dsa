package stack;

import java.util.Scanner;
import java.util.Stack;

public class move {
    static void copy(Stack<Integer> st){
        // reverse order
        Stack<Integer> rv = new Stack<>();
        while (st.size()>0) {
            rv.push(st.pop());
            
        }
        // copying stack from reverse oder
        Stack<Integer> cv = new Stack<>();
        while (rv.size()>0) {
            cv.push(rv.pop());
        }
        System.out.println(cv);
    }

    static Stack<Integer> insertBottom(Stack<Integer> st, int val){
        Stack<Integer> rt = new Stack<>();
        while (st.size() > 0) {
            rt.push(st.pop());
        }
        st.push(val);
        while (rt.size() > 0) {
            st.push(rt.pop());
        }

        return st;
    }

    static Stack<Integer> removeBottom(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>();
        while (st.size() > 1) {
            rt.push(st.pop());
        }
        st.pop();
        while (rt.size() > 0) {
            st.push(rt.pop());
        }

        return st;
    }

    static Stack<Integer> insertAt(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index and value to be inserted: ");
        int idx = sc.nextInt();
        int val = sc.nextInt();

        while (st.size() > idx) {
            rt.push(st.pop());
        }
        st.push(val);
        while (rt.size() > 0) {
            st.push(rt.pop());
        }

        return st;
    }

    static void display(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>();
        while (st.size()>0) {
            rt.push(st.pop());
        }
        while (rt.size()>0) {
            int x = rt.pop();
            System.out.print(x+" ");
            st.push(x);
        }
        System.out.println();
    }

    static void display2(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>();
        int n = st.size();
        int[] arr = new int[n];
        for (int i = n - 1; i >=0 ; i--) {
            arr[i] = st.pop();
        }
        for (int i : arr) {
            System.out.print(i+" ");
            st.push(i);
        }
        System.out.println();
    }
    
    static void displayR(Stack<Integer> st){
        if(st.size() <= 0) return;
        int x = st.pop();
        displayR(st);
        st.push(x);
        System.out.print(x+" ");
        
    }

    static Stack<Integer> reverse(Stack<Integer> st){
        Stack<Integer> rt = new Stack<>();
        while (st.size()>0) {
            rt.push(st.pop());
        }
        Stack<Integer> qt = new Stack<>();
        while (rt.size()>0) {
            qt.push(rt.pop());
        }
        while (qt.size()>0) {
            st.push(qt.pop());
        }
        return st;
    }
    
    static Stack<Integer> reverseR(Stack<Integer> st){
        if(st.size()==1) return st;
        int top = st.pop();
        Stack<Integer> rev = reverseR(st);
        insertBottomR(st, top);
        return rev;
    }

    static Stack<Integer> insertBottomR(Stack<Integer> st, int val){
        if(st.size() == 0) {
            st.push(val);
            return st;
        }
        int top = st.pop();
        Stack<Integer> bt = insertBottomR(st, val);
        st.push(top);
        return bt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> st = new Stack<>();
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        for (int index = 0; index < n; index++) {
            st.push(sc.nextInt());
        }
        // displayR(st);
        // copy(st);
        // System.out.println(insertBottomR(st, 13));
        // System.out.println(insertAt(st));
        System.out.println("Reverse: "+reverseR(st));
        
    }
    
}

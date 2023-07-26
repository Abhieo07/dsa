package Queue;

public class linkedlistImpl {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.display();
        System.out.println(q.isEmpty());
        for (int i = 1; i < 11; i++) {
            q.add(i);
        }
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        q.display();
        System.out.println(q.peek());
        q.add(13);
        q.display();
        System.out.println(q.size());
    }
    
}

class Queue{
    private class Node{
        private int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    void add(int val){
        Node temp = new Node(val);
        if(size == 0){
            head = tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    int peek(){
        if(size == 0){
            System.out.println("Queue Empty");
            return Integer.MIN_VALUE;
        }
        return head.val;
    }

    int remove(){
        if(size == 0){
            System.out.println("Queue Empty");
            return Integer.MIN_VALUE;
        }
        int x = head.val;
        head = head.next;
        size--;
        return x;
    }

    void display(){
        if(size == 0){
            System.out.println("Queue Empty");
            return;
        }
        Node temp = head;
        System.out.print("[");
        while (temp!=null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.print("]");
        System.out.println();
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

}

package LinkedList;

public class circularSll {
    static void display(Node head){
        Node temp = head;
        while(temp.next != head){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.print(temp.val+" ");//for last one
        System.out.println();
    }
  
    static Node delHead(Node head){
        Node temp = head;
        while (temp.next != head) {
            temp =temp.next;
        }
        head = head.next;
        temp.next = head;
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);
       
        a.next = b;
        b.next = c; 
        c.next = d; 
        d.next = e;
        e.next = a;

        display(a);
        display(delHead(a));
    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

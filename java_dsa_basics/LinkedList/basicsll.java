package LinkedList;

public class basicsll {

    static void display(Node head){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void displayR(Node head){
        if(head == null) return;
        System.out.print(head.data + " ");
        displayR(head.next);
    }

    static void displayReverse(Node head){
        if(head == null) return;
        displayReverse(head.next);
        System.out.print(head.data+" ");
        
    }

    static int length(Node head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    static void insertEnd(Node head,int val){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        // Node end = 
        temp.next = new Node(val);
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        // System.out.println(a.next);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);
        // 5  3  9  8  16
        a.next = b; // 5 -> 3  9  8  16
        b.next = c; // 5 -> 3 -> 9  8  16
        c.next = d; // 5 -> 3 -> 9 -> 8  16
        d.next = e; // 5 -> 3 -> 9 -> 8 -> 16
        insertEnd(a, 100);

        displayR(a);
        System.out.println();
        displayReverse(a);
        System.out.println("\nlength : "+length(a));
        
    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

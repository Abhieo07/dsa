package LinkedList;

public class dll {
    static void display(Node head){
        if(head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.val+" ");
        display(head.next);
    }

    static void display2(Node tail){
        if(tail == null) {
            System.out.println();
            return;
        }
        System.out.print(tail.val+" ");
        display2(tail.prev);
    }

    static void display3(Node rand){
        Node temp1 = rand;
        // Node temp2 = rand;
        // while(temp1 != null && temp2 != null){
        //     System.out.print(temp1.val+" ");
        //     temp1 = temp1.prev;
        //     if(temp2.next == null) break;
        //     System.out.print(temp2.next.val+" ");
        //     temp2 = temp2.next;
        // }
        // System.out.println();

        // approach 2
        while(temp1.prev != null){
            temp1 = temp1.prev;
        }
        display(temp1);
    }

    static Node insertHead(Node head,int val){
        Node t = new Node(val);
        t.next = head;
        head.prev = t;
        head = t;

        return head;
    }

    static Node insertTail(Node tail, int val){
        Node t = new Node(val);
        tail.next = t;
        t.prev = tail;
        tail = t;

        return tail;
    }

    static Node insertTail2(Node head, int val){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node t = new Node(val);
        temp.next = t;
        t.prev = temp;

        return head;
    }

    static Node insetNode(Node head, int idx, int val){
        Node temp = head;
        int n = 0;
        while(n < idx){
            temp = temp.next;
            n++;
        }
        Node t = new Node(val);
        t.next = temp;
        t.prev = temp.prev;
        temp.prev.next = t;
        temp.prev = t;
        
        return head;
    }

    static Node deleteHead(Node head){
        head = head.next;
        head.prev = null;
        return head;
    }

    static Node deleteTail(Node head){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp = temp.prev;
        temp.next = null;
        return head;
    }

    static Node deleteNode(Node head, int idx){
        Node temp = head;
        int n = 0;
        while(n < idx){
            temp = temp.next;
            n++;
        }
        temp = temp.prev;
        temp.next = temp.next.next;
        temp.next.prev = temp;
        
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
        b.prev = a;
        c.next = d; 
        c.prev = b;
        d.next = e;
        d.prev = c;
        e.prev = d;
        // display(insertHead(a, 30));
        // display2(insertTail(e, 30));
        display(insetNode(a, 2, 30));
        // display(deleteHead(a));
        // display(deleteTail(a));
        display(deleteNode(a, 2));
        display(a);
        display2(e);
        display3(c);
        
    }
    
}

class Node{
    int val;
    Node next;
    Node prev;
    Node(int val){
        this.val = val;
    }
}

package LinkedList;

public class randomCopy {
    static void display(Node head){
        if(head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.val+","+head.random+" ");
        display(head.next);
    }

    static Node copyList(Node head){
        // 1 make simple deep copy
        Node nHead = new Node(0);
        Node p1 = nHead;
        Node temp = head;

        while(temp != null){
            Node a = new Node(temp.val);
            p1.next = a;
            p1 = a;
            temp = temp.next;
        }
        nHead = nHead.next;

        // 2 alternate connections
        Node t = new Node(0);
        Node t1 = head;
        Node t2 = nHead;
        while (t1 != null && t2 != null) {
            t.next = t1;
            t1 = t1.next;
            t = t.next;

            t.next = t2;
            t2 = t2.next;
            t = t.next;
        }

        // 3 assigning random pointers t2.random = t1.random.next
        t1 = head;
        t2 = nHead;
        while(t1 != null){
            if(t1.random == null) t2.random = null;
            else t2.random = t1.random.next;
            t1 = t1.next.next;
            if(t2.next != null)
            t2 = t2.next.next;
        }

        // 4 separate 
        t1 = head;
        t2 = nHead;
        while (t1 != null) {
            t1.next = t2.next;
            t1 = t1.next;
            if(t1 == null) break;
            t2.next = t1.next;
            if(t2.next == null) break;
            t2 = t2.next;
        }


        return nHead;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
       
        a.next = b; //a.random = null;
        b.next = c; 
        b.random = a;
        c.next = d; 
        c.random = e;
        d.next = e;
        d.random = c;
        e.random = a;
        display(copyList(a));
    }
}

class Node{
    int val;
    Node next;
    Node random;
    Node(int val){
        this.val = val;
    }
}

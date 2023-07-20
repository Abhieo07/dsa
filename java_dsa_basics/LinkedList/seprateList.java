package LinkedList;

public class seprateList {
    static void display(Node head){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    
    static void seprateLists1(Node head){
        Node odd = new Node(1);
        Node even = new Node(2);
        Node temp = head;
        Node i = odd;
        Node j = even;

        while (temp != null) {
            if(temp.data % 2 == 0){
                Node a = new Node(temp.data);
                j.next = a;
                j = a;
            } else {
                Node a = new Node(temp.data);
                i.next = a;
                i = a;
            }
            temp = temp.next;
        }
        display(odd.next);
        display(even.next);
        return;
    }

    static void seprateLists2(Node head){
        Node odd = new Node(1);
        Node even = new Node(2);
        Node temp = head;
        Node i = odd;
        Node j = even;

        while (temp != null) {
            if(temp.data % 2 == 0){
                j.next = temp;
                j = temp;
            } else {
                i.next = temp;
                i = temp;
            }
            temp = temp.next;
        }
        while (j != null) {
            if(j.next != null && j.next.data % 2 != 0)
                j.next = null;
            j = j.next;
        }

        while (i != null) {
            if(i.next != null && i.next.data % 2 == 0)
                i.next = null;
            i = i.next;
        }

        display(odd.next);
        display(even.next);
        return;
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(8);
        Node d = new Node(11);
        Node e = new Node(13);
        Node a1 = new Node(4);
        Node b1 = new Node(6);
        Node c1 = new Node(7);
        Node d1 = new Node(10);
        
        // 5  3  9  8  16
        a.next = b; // 5 -> 3  9  8  16
        b.next = c; // 5 -> 3 -> 9  8  16
        c.next = d; // 5 -> 3 -> 9 -> 8  16
        d.next = e;
        e.next = a1; // 5 -> 3 -> 9 -> 8 -> 16
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        seprateLists2(a);
    }

}

class Node{
    int data;
    Node next;
    // static int size;
    Node(int data){
        this.data = data;
        // size++;
    }
}

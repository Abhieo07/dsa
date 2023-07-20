package LinkedList;

public class mergeSort {

    static void display(Node head){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // space: O(n)
    static Node mergeSortM1(Node head1, Node head2){
        Node i = head1;
        Node j = head2;
        Node head = new Node(100);
        Node temp = head;
        while(i != null && j != null){
            if(i.data > j.data){
                Node a = new Node(j.data);
                temp.next = a;
                temp = a;
                j = j.next;
            }else {
                Node a = new Node(i.data);
                temp.next = a;
                temp = a;
                i = i.next;
            }
        }

        while (i != null) {
            temp.next = i;
            temp = i;
            i = i.next;
        }

        while (j != null) {
            temp.next = j;
            temp = j;
            j = j.next;
        }
        return head.next;
    }

    static Node mergeSortM2(Node head1, Node head2){
        Node i = head1;
        Node j = head2;
        Node head = new Node(100);
        Node temp = head;

        while (i != null && j != null) {
            if(i.data < j.data){
                temp.next = i;
                temp = i;
                i = i.next;
            } else {
                temp.next = j;
                temp = j;
                j = j.next;
            }
        }
        if(i == null)
            temp.next = j;
        
        if(j == null)
            temp.next = i;

        return head.next;
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
        a1.next = b1; // 5 -> 3 -> 9 -> 8 -> 16
        b1.next = c1;
        c1.next = d1;
        display(a);
        display(a1);
        display(mergeSortM2(a, a1));
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

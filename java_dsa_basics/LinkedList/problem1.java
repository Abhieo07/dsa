package LinkedList;
/*Can we delete a node given the node itself parameter
 * Is there any efficient way, provided that the given node is 
 * not the last node?
 */
public class problem1 {

    static void display(Node head){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node getNode(Node head, int n){
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        temp = head; //reinitiallize it to the head
        for (int i = 0; i < size - n; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // in one traversal
    static Node getNode1(Node head, int n){
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    static void delete(Node temp){
        if(temp.next == null){//last node
            temp = null;
        }
        temp.data = temp.next.data;
        temp.next = temp.next.next;
    }

    static int removeNth(Node head, int n){
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null){//if fast reached the tail.next means we n = size thus head to be deleted
            int data = slow.data;
            slow.data = slow.next.data;
            slow.next = slow.next.next;
            return data;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        int data = slow.next.data;/*
        slow is previous 
        slow.next is the node to be deleted
        fast is the next of slow.next  */
        //removing node
        slow.next = slow.next.next;

        return data;
    }

    static Node intersectionNode(Node head1, Node head2){
        int m = 0,n = 0;
        Node temp1 = head1;
        // finding length of 1st
        while(temp1 != null){
            m++;
            temp1 = temp1.next;
        }
        // finding length of 2nd
        Node temp = head2;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        temp1 = head1;
        temp = head2;
        if (m > n) {
            temp1 = head1;
            for (int i = 0; i < m - n; i++) {
                temp1 = temp1.next;
            }
        } else {
            temp = head2;
            for (int i = 0; i < n - m; i++) {
                temp = temp.next;
            }
        }
        while(temp != temp1){
            temp1 = temp1.next;
            temp = temp.next;
        }
        if(temp == temp1)
            return temp;
        
        return null;
    }

    static Node middlNode(Node head){
        Node slow = head;
        Node fast = head;
/*for odd number of nodes -->fast.next != null
 * for even number of nodes(left middle) -->fast.next.next != null
 */
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node delMiddNode(Node head){
        Node slow = head;
        Node fast = head;

        if(fast.next == null) return null; // only one node

        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the prev middle one we have to remove that
        // slow.data = slow.next.data;
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);
        Node f = new Node(10);
        Node a1 = new Node(90);
        Node b1 = new Node(12);
        // 5  3  9  8  16
        a.next = b; // 5 -> 3  9  8  16
        b.next = c; // 5 -> 3 -> 9  8  16
        c.next = d; // 5 -> 3 -> 9 -> 8  16
        d.next = e; // 5 -> 3 -> 9 -> 8 -> 16
        e.next = f;
        a1.next = b1;
        b1.next = d;
        display(a);
        // System.out.println(getNode1(a, 2).data);
        // delete(d);
        // System.out.println(removeNth(a, 5));
        display(a1);
        // System.out.println("Middle node: "+delMiddNode(a1).data);
        display(delMiddNode(a1));
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

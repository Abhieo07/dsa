package LinkedList;

public class reverse {
    static void display(Node head){
        if(head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.val+" ");
        display(head.next);
    }
    static void displayR(Node head){
        if(head == null) if(head == null) {
            System.out.println();
            return;
        } //base case
        displayR(head.next); //call
        System.out.print(head.val+" "); //work
    }

    static Node reverList(Node head){
        if(head.next == null) {
            return head;
        }
        Node newHead = reverList(head.next);
        head.next.next = head; //interchanging the connections
        head.next = null;
        return newHead;
        
    }

    static Node irevList(Node head){
        Node curr = head;
        Node prev = null;
        Node after = null;
        while(curr != null){
            after = curr.next; //after ko curr k next node
            curr.next = prev; // curr ko prev
            prev = curr; // prev ko curr
            curr = after; // curr ko aage

        }
        return prev;
    }

    static Node irevList2(Node head, int left, int right){
        Node l = head;
        Node r = head;
        int c = 0,x=0;
        Node curr = head;
        while (curr != null) {
            if(c+1 == left) l = curr;
            c++;
            curr =curr.next;
        }
        curr = head;
        while (curr != null) {
            if(c-right == x+1) r = curr;
            x++;
            curr =curr.next;
        }
        while (left < right) {
            
        }

        
        Node prev = null;
        Node after = null;
        while(curr != null){
            after = curr.next; //after ko curr k next node
            curr.next = prev; // curr ko prev
            prev = curr; // prev ko curr
            curr = after; // curr ko aage

        }
        return prev;
    }

    static boolean isPallindrome(Node head){
        // calculate left middle of list
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is at middle now reverse list from slow.next
        Node rev = irevList(slow.next);
        while(rev != null){
            if(head.val != rev.val){
                return false;
            }
            head = head.next;
            rev = rev.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node a1 = new Node(3);
        Node b1 = new Node(2);
        Node c1 = new Node(5);
        Node d1 = new Node(1);
       
        a.next = b; 
        b.next = c; 
        c.next = d; 
        d.next = e;
        e.next = a1; 
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        System.out.println("Display: ");
        display(a);
        System.out.println("reverse: ");
        display(irevList(a));
        System.out.println("Is pallindrome: "+isPallindrome(a));
    }

}

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

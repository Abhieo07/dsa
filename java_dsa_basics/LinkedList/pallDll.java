package LinkedList;

public class pallDll {
    static void display(Node head){
        if(head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.val+" ");
        display(head.next);
    }

    static boolean isPalllindrome(Node head){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node tail = temp;
        temp = head;
        while (temp != tail) {
            if(temp.val != tail.val)
                return false;
            temp = temp.next;
            tail = tail.prev;
        }
        return true;
    }

    // for sorted linked list whose sum of two nodes = target
    static void twoSum(Node head, int target){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node t = temp;
        Node h = head;
        while (h.val < t.val) {
            if(h.val + t.val == target){
                System.out.println(h.val+" and "+ t.val);
                return;
            }else if(h.val + t.val > target){
                t = t.prev;
            } else h = h.next;
        }
        System.out.println("No such pair found");
    }

    static void criticalPoints(Node head){
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            if(temp.next == null) break;
            if(temp.val > temp.next.val && temp.val > temp.prev.val){
                System.out.println("Maxima :"+temp.val);
            }
            if(temp.val < temp.next.val && temp.val < temp.prev.val){
                System.out.println("Minima : "+temp.val);
            }
        }
        // Node t = 
    }
    
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(1);
        Node e = new Node(12);
       
        a.next = b;
        b.next = c; 
        b.prev = a;
        c.next = d; 
        c.prev = b;
        d.next = e;
        d.prev = c;
        e.prev = d;
        System.out.println(isPalllindrome(a));
        display(a);
        twoSum(a, 12);
        criticalPoints(a);
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

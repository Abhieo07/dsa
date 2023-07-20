package LinkedList;

public class removeDup {
    static void display(Node head){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node removeDupNode(Node head){
        Node temp = head;
        while (temp != null && temp.next != null) {
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
            
        }


        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(3);
        Node a1 = new Node(3);
        Node b1 = new Node(4);
        Node c1 = new Node(5);
        Node d1 = new Node(5);
       
        a.next = b; 
        b.next = c; 
        c.next = d; 
        d.next = e;
        e.next = a1; 
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        display(removeDupNode(a));
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

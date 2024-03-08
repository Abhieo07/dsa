
class LinkedList{
    public Node create(int[] arr){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node t = new Node(arr[i]);
            temp.next = t;
            temp = temp.next;
        }
        return head;
    }
    
    public void print(Node head){
        if(head==null){
            System.out.println("null");
            return;
        }
        Node t = head;
        while(t!=null){
            System.out.print(t.data+"-->");
            t = t.next;
        }
        System.out.println("null");
    }
    
    public boolean isCycle(Node head){
        Node slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    
    public Node removeLoop(Node head){
        if(this.isCycle(head)){
            Node slow = head,fast=head;
            while(true){
                slow=slow.next;
                fast = fast.next.next;
                if(slow==fast){
                    slow = head;
                    break;
                }
            }
            Node prev = null;
            while(slow!=fast){
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
            return head;
        }
        System.out.println("No Cycle present");
        return null;
    }
}

class Node{
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
    }
    
}

public class Main
{
	public static void main(String[] args) {
	    LinkedList ll = new LinkedList();
// 		System.out.println("testing create funtion");
// 		int[] listdata = {1,2,3,2,1,6};
// 		Node head = ll.create(listdata);
// 		ll.print(head);
        Node head = new Node(1);
        Node a = new Node(2);
        head.next = a;
        Node b = new Node(3);
        a.next = b;
        Node c = new Node(2);
        b.next = c;
        Node d = new Node(1);
        c.next = d;
        Node e = new Node(6);
        d.next = e;
        e.next = c;
        System.out.println("testing isCycle? ");
        System.out.println(ll.isCycle(head));
        ll.print(ll.removeLoop(head));
	}
}

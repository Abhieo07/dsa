
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
    
    
    public Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    
    public Node deleteNthEnd(Node head,int n){
        // get size of ll
        Node t=head;
        int size=0;
        while(t!=null){
            size++;
            t = t.next;
        }
        if(n==size){
            head = head.next;
            return head;
        }
        // delete (size-n+1)th node from begining
        t = head;
        int i = 1;
        while(i<(size-n)){ // previous node
            i++;
            t = t.next;
        }
        Node p = t;
        p.next = t.next.next;
        
        return head;
    }
    
    public boolean pallindrome(Node head){
        if(head == null || head.next == null) return true;
        Node slow = head, fast = head;
        //    for even            for odd
        while(fast!=null && fast.next!=null){ // get the middle node
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node halfhead = reverse(slow); // reverse the 2nd half
        slow = head;
        while(halfhead!=null){ // compare
            if(slow.data != halfhead.data) return false;
            slow = slow.next;
            halfhead = halfhead.next;
        }
        
        return true;
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
		System.out.println("testing create funtion");
		int[] listdata = {1,2,3,2,1,6};
		Node head = ll.create(listdata);
		ll.print(head);
// 		System.out.println("testing reverse funtion");
// 		ll.print(ll.reverse(head));
// 		System.out.println("delete nth node from last");
// 		ll.print(ll.deleteNthEnd(ll.reverse(head),3));
        System.out.println("Check pallindrome");
		System.out.println(ll.pallindrome(head));
	}
}

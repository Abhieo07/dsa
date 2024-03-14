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
    
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public Node merge(Node lh, Node rh){
        Node mergeList = new Node(Integer.MIN_VALUE);
        Node temp = mergeList;
        while(lh!=null && rh!=null){
            if(lh.data <= rh.data){
                temp.next = lh;
                lh = lh.next;
            }else{
                temp.next = rh;
                rh = rh.next;
            }
            temp = temp.next;
        }
        temp.next = lh!=null?lh:rh!=null?rh:null;
        // if(lh!=null){
        //     temp.next = lh;
        // }
        // if(rh!=null){
        //     temp.next = rh;
        // }
        
        return mergeList.next;
    }
    
    public Node mergeSort(Node head){
        if(head==null || head.next==null) return head; // base case 
        // get mid
        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;
        
        // Sort both halves
        Node leftHalf = mergeSort(head);
        Node rightHalf = mergeSort(rightHead);
        
        // merge both sorted
        return merge(leftHalf,rightHalf);
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
        
        return prev;
    }
    
    public Node zigZag(Node head){
        // get mid
        Node mid = getMid(head);
        Node rh = mid.next;
        mid.next = null;
        
        // reverse 2nd half
        rh = reverse(rh);
        
        // alternate merging
        Node lh = head;
        Node nextL,nextR;
        while(lh!=null && rh!=null){
            //zigZag
            nextL = lh.next;
            lh.next = rh;
            nextR = rh.next;
            rh.next = nextL;
            
            // iteration
            lh = nextL;
            rh = nextR;
        }
        return head;
    }

}

class Node{
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
    }
    
}

// import java.util.LinkedList;
public class Main
{

	public static void main(String[] args) {
	    int[] data = {11,5,9,8,3};
	    LinkedList ll = new LinkedList();
	    Node h = ll.create(data);
	    ll.print(h);
	    
		ll.print(ll.zigZag(h));
	}
}

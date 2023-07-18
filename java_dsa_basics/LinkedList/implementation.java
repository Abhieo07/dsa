package LinkedList;

public class implementation {
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertBegining(13);
        ll.insertEnd(7);
        ll.insertEnd(5);
        ll.insertBegining(3);
        ll.insertBegining(6);
        ll.display();
        ll.inserAt(2, 21);
        ll.display();
        System.out.println(ll.deleteAt(0));
        ll.delete(21);
        ll.display();
        System.out.println(ll.size);
        System.out.println(ll.getAt(2));
    }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

class linkedList{
    Node head = null;
    Node tail = null;
    int size;

    void inserAt(int idx, int data){
        if(idx == 0) {
            insertBegining(data);
            return;
        }else if(idx == size){
            insertEnd(data);
            return;
        } else if(idx < 0 || idx > size){
            System.out.println("Wrong index entered!");
            return;
        }
        //traverse till idx then insert
        Node prev = head;
        for (int i = 1; i < idx; i++) {
            prev = prev.next;
        }
        Node temp = new Node(data);
        temp.next = prev.next;
        prev.next = temp;
        size++;
    }

    void insertEnd(int data){
        Node temp = new Node(data);
        if(head == null){//if ll is empty
            head = temp;
        } else{
            tail.next = temp;
        }
        tail = temp;
        size++;
    }

    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void insertBegining(int data){
        Node temp = new Node(data);
        if(head == null){
            head = tail = temp; // insertEnd(data)
        }
        temp.next = head;
        head = temp;
        size++;
    }

    void delete(int data){
        Node temp = head;
        if(data == head.data) {
            head = head.next;
            size--;
            return;
        }
        for (int i = 0; i < size; i++) {
            if(temp.data == data){
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    int deleteAt(int idx){
        if(idx < 0 || idx > size){
            System.out.println("Wrong index entered!");
            return -1;
        } else if(idx == 0){
            int data = head.data;
            head = head.next;
            size--;
            return data;
        }
        Node temp = head;
        int data;
        for (int i = 1; i < idx; i++) {
            temp = temp.next;
        }
        data = temp.next.data;
        temp.next = temp.next.next;
        tail = temp;
        size--;
        return data;
    }

    int getAt(int idx){
        Node temp = head;
        if(idx < 0 || idx > size){
            System.out.println("Wrong index entered!");
            return -1;
        }
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp.data;
    }



}

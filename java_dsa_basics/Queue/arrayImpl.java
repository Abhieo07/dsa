package Queue;

public class arrayImpl {
    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 1; i < 11; i++) {
            q.add(i);
        }
        q.display();
        System.out.println(q.remove());
        q.display();
        System.out.println(q.peek());
        q.add(13);
        q.display();
    }
}

class Queue{
    private int arr[] = new int[50];
    private int front = 0; //remove --> front++ ,rear
    private int rear = 0; // add --> rear++,front
    private int size = 0;

    void add(int val){
        if(size() == arr.length){
            System.out.println("Queue Overflow\n");
            return;
        }
        arr[rear++] = val;
        size++;
    }
    int remove(){
        if(size() == 0) {
            System.out.println("Queue underflow\n");
            return Integer.MIN_VALUE;
        }
        int x = arr[front++];
        size--;
        return x;
    }
    int peek(){
        if(size() == 0) {
            System.out.println("Queue underflow\n");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }
    int size(){
        return size;
    }
    void display(){
        if(size() == 0){
            System.out.println("Queue Underflow");
            return;
        }
        System.out.print("[");
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.print("]");
        System.out.println();
    }
}

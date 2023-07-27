package Queue;

public class circular {
    public static void main(String[] args) throws Exception{
        Queue q = new Queue();
        q.display();
        System.out.println(q.isEmpty());
        for (int i = 1; i < 10; i++) {
            q.add(i);
        }
        q.display();
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        q.display();
        System.out.println(q.peek());
        q.add(13);
        q.display();
        q.add(54);
        q.display();
        System.out.println(q.size());
    }
}

class Queue{
    private int[] arr = new int[10];
    private int f=-1;
    private int r=-1;
    private int size = 0;

    void add(int x) throws Exception{
        if(size == 0){
            f = r = 0;
            arr[0] = x;
        }
        else if(size == arr.length - 1){
            r = 0;
            arr[0] = x;
        }
        else if(size == arr.length){
            throw new Exception("Queue is full");
        }
        else arr[++r] = x;
        size++;
    }

    int remove() throws Exception{
        if(size == 0){
            throw new Exception("Queue Empty");
        }
        else{
            int val = arr[f];
            if(f == arr.length - 1) f = 0;
            else f++;
            size--;
            return val;
        }
    }

    int peek() throws Exception{
        if(size == 0){
            throw new Exception("Queue Empty");
        }
        return arr[f];
    }

    boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

    int size(){
        return size;
    }

    void display(){
        if(size == 0){
            System.out.println("Queue empty");
        }
        else if(f <= r){
            for (int i = f; i <= r; i++) {
                System.out.print(arr[i]+" ");
            }
        }
        else{
            for (int i = f; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            for (int i = 0; i <= r; i++) {
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}

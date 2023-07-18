package Oops;

import java.util.Arrays;

public class arraylist {
    static class ArrayList{
        int[] arr = new int[2];
        static int i;
    
        public void add(int x){
            if(i == arr.length){
                int[] brr = Arrays.copyOf(arr,arr.length * 2);
                arr = brr; // this is just changing the name of brr --> arr since both arrays points to the same hash map
            }
            arr[i++] = x;
        }

        public void set(int idx, int x){
            arr[idx] = x;
        }

        public int get(int idx){
            return arr[idx];
        }

        public int size(){
            return i;
        }

    }
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(2);
        arr.add(3);
        System.out.println(arr.size());
        arr.add(5);
        System.out.println(arr.size());
        arr.set(0, 10);

    }
}

package stack;
import java.util.Stack;;

public class prevGreater {

    static int[] previousGreater(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < res.length; i++) {
            while(st.size() > 0 && st.peek() < arr[i]){
                st.pop();
            }
            if(st.size() == 0) res[i] = -1;
            else res[i] = st.peek();

            st.push(arr[i]);
        }

        return res;
    }
    
    static int[] stockSpan(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(st.size() > 0 && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.size() == 0) res[i] = 1;
            else res[i] = i -  st.peek(); // curr - top
            st.push(i);
        }
        

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int[] res = stockSpan(arr);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}


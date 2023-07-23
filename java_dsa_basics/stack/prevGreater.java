package stack;
import java.util.Stack;;

public class prevGreater {

    static int[] previousGreater(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[0] = -1;
        st.push(arr[0]);
        for (int i = 1; i < res.length; i++) {
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
        Stack<Integer> it = new Stack<>();
        res[0] = 1;
        st.push(arr[0]);
        it.push(0);
        for (int i = 1; i < n; i++) {
            while(it.size() > 0 && st.peek() < arr[i]){
                st.pop();
                it.pop();
            }
            if(it.size() == 0) res[i] = 1;
            else res[i] = i -  it.peek(); // curr - top

            st.push(arr[i]);
            it.push(i);
        }
        

        return res;
    }

    // static int[] stockSpan2(int[] arr){
    //     int n = arr.length;
    //     int[] res = new int[n];
    //     Stack<Integer> st = new Stack<>();
    //     res[0] = -1;
    //     pair p = new pair(arr[0], 0);
    //     st.push(p.val);
    //     for (int i = 1; i < n; i++) {
    //         p.val = arr[i];
    //         while(st.size() > 0 && st.peek() < p.val){
    //             st.pop();
    //         }
    //         res[i] = st.peek();
            
    //         p.idx = i;
    //         st.push(p.val);
    //     }

    //     return res;
    // }
    

    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85};
        int[] res = stockSpan(arr);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}

class pair{
    int val;
    int idx;
    pair(int val,int idx){
        this.val = val;
        this.idx = idx;
    }
}

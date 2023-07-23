package stack;
import java.util.Stack;

public class nextGreater {
    // iterative method O(n2)
    static int[] nextGreaterElements(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[i]){
                    res[i] = arr[j];
                    break;
                }
            }
        }

        return res;
    }
// using stack O(n)
    static int[] nextGreaterElements2(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[n-1] = -1;
        st.push(arr[n-1]);
        
        for (int i = n-2; i >=0; i--) {
            while (st.size() > 0 && st.peek() < arr[i]) {
                st.pop();
            }
            if(st.size() == 0) res[i] = -1;
            else res[i] = st.peek();
            st.push(arr[i]);
        }

        return res;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};
        int[] res = nextGreaterElements2(arr);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}

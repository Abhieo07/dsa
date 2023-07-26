package stack;
import java.util.Stack;
// Sliding window maximum

public class slidingWin {
    // O(k*(n-k+1)) --> O(n*k)
    static int[] slidingWinMax(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for (int i = 0; i < n - k + 1; i++) {
            int mx = Integer.MIN_VALUE;
            int j = i;
            while (j < i+k) {
                if(nums[j] > mx) mx = nums[j];
                j++;
            }
            ans[i] = mx;
        }
        return ans;
    }
    static int[] slidingWindowMax(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n - 1] = n;
        st.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while (st.size() > 0 && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if(st.size() == 0) nge[i] = n;
            else nge[i] = st.peek();
            st.push(i);
        }
        int j = 0;
        for (int i = 0; i < n - k + 1; i++) {
            if(j >= i + k) j = i;
            int max = nums[i];
            while (j < i+k) {
                max = nums[j];
                j = nge[j];
            }
            ans[i] = max;
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] max = slidingWindowMax(arr, k);
        for (int i : max) {
            System.out.print(i+" ");
        }
        System.out.println();
        
    }
}

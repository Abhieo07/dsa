package stack;
import java.util.Stack;

public class largestRect {

    static int[] nextSmallerEle(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[n - 1] = n; //next samller is not available
        st.push(n-1);

        for (int j = n-2; j >= 0; j--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[j]) {
                st.pop();
            }
            if(st.size() == 0) res[j] = n;
            else res[j] = arr[st.peek()];
            st.push(j);
        }

        return res;
    }

    static int[] previousSmallerEle(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[0] = -1;
        st.push(0);

        for (int j = 1; j < n; j++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[j]) {
                st.pop();
            }
            if(st.size() == 0) res[j] = -1;
            else res[j] = arr[st.peek()];
            st.push(j);
        }

        return res;
    }
    
    static int largestRectangleArea(int[] height){
        int maxArea = -1;
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];
        // calculating nse
        st.push(n-1); //index
        nse[n-1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if(st.size() == 0) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }
        // emptying stack
        while(st.size()>0){
            st.pop();
        }

        // calculating pse
        st.push(0);
        pse[0] = -1;
        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if(st.size() == 0) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }
        // maximum area of rectangle
        for (int i = 0; i < n; i++) {
            int area = height[i] * (nse[i] - pse[i] - 1);
            if(area > maxArea)
                maxArea = area;
        }


        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,4,6,3,5};
        int[] arr2 = {1,1};
        int[] res = nextSmallerEle(arr2);
        for (int i : res) {
            System.out.print(i+" ");
        }
        System.out.println("Largest rectangle area: "+ largestRectangleArea(arr));

    }
}

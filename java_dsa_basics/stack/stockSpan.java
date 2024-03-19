// Stock span problem using Stack

import java.util.*;
public class Main
{
    public static int[] stockSpan(int[] stocks){
        int[] span = new int[stocks.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;
        
        for(int i=1; i<stocks.length; i++){
            while(!st.isEmpty() && stocks[i] >= stocks[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i] = i+1;
            }else span[i] = i - st.peek();
            st.push(i);
        }
        return span;
    }
    
	public static void main(String[] args) {
		System.out.println("Stock span problem");
		int[] stocks = {100,80,60,70,60,85,100};
		int[] span = stockSpan(stocks);
		for(int i:span){
		    System.out.print(i+" ");
		}
		System.out.println();
	}
}

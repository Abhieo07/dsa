package leetcode;
/*
 * Stock Buy Sell to Maximize Profit using Valley Peak Approach:

In this approach, we just need to find the next greater element and subtract it from the current 
element so that the difference keeps increasing until we reach a minimum. If the sequence is a 
decreasing sequence, so the maximum profit possible is 0.
 */
public class valleyPeak {
    static int maxProfit(int [] prices){
        int maxProfit = 0;
  
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        return maxProfit;
    }

    public static void main(String[] args)
    {
  
        int price[] = {6,1,3,2,4,7};
        
        System.out.println(maxProfit(price));
    }
}

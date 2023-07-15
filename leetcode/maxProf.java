package leetcode;

public class maxProf {
    static int maxProfit(int[] prices) {
        // int prof = 0;
        // for(int i = 0; i < prices.length; i++){

        //     int buy = prices[i];
        //     for(int j = i + 1; j < prices.length; j++){
        //         if(prices[j] - buy > prof)
        //             prof = prices[j] - buy;
        //     }
        // }
        int prof = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - min > prof){
                prof = prices[i] - min;
                
            }
            if(prices[i] < min)
                min = prices[i];
        }
       

        return prof;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println("Max Profit : "+maxProfit(arr));
        
    }
}

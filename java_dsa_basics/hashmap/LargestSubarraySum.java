package java_dsa_basics.hashmap;

import java.util.HashMap;


public class LargestSubarraySum {
    // largest subarray whoose sum is 0
    static int largestSum0(int[] nums){
        HashMap<Integer, Integer> mp = new HashMap<>();
        int prefSum = 0;
        int mxLen = 0;
        mp.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefSum += nums[i];
            if(mp.containsKey(prefSum)){
                mxLen = Math.max(mxLen, i-mp.get(prefSum));
            }
            else mp.put(prefSum, i);
        }
        return mxLen;
    }

    static int totalSum0Subarray(int[] nums){
        HashMap<Integer, Integer> mp = new HashMap<>();
        int prefSum = 0;
        int count = 0;
        mp.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefSum += nums[i];
            if(mp.containsKey(prefSum)){
                prefSum = 0;
                count++;
            }
            else mp.put(prefSum, i);
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10};
        System.out.printf("length of largest subarray whoose sum is 0: %d \n", largestSum0(arr));
        System.out.printf("and total %d subarray with sum zero",totalSum0Subarray(arr));
    }
}

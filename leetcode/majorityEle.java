package leetcode;
/*
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

 */
public class majorityEle {
    static int majorityElement(int[] nums) {
        int[] freq = new int[1000];
        for(int i = 0; i < nums.length; i++){
            freq[10+nums[i]]++;
        }

        int max = freq[0];
        int idx = 0;
        for(int x = 1; x < freq.length; x++){
            if(freq[x] > max){
                max = freq[x];
                idx = x-10;
            }
           
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {-1,1,1,1,2,1};
        System.out.println(majorityElement(arr));
    }
    
}

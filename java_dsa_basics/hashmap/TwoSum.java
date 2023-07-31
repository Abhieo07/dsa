package java_dsa_basics.hashmap;

import java.util.HashMap;

public class TwoSum {
    // brute force approach
    static int[] twoSum(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] == target - ele) return new int[] {i,j};
            }
        }
        return new int[] {-1};
    }

    static int[] twoSum2(int[] arr, int target){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(mp.containsKey(target-arr[i])){
                return new int[] {mp.get(target-arr[i]), i};
            }
            else mp.put(arr[i], i);
        }
        return new int[] {-1};
    }

    static int[] tripletSum(int[] arr, int target){
        
    }

    public static void main(String[] args) {
        int[] arr = {14,7,10,4,5,9,1,2};
        int target = 6;
        int[] ans = twoSum2(arr, target);
        int[] ans2 = twoSum2(arr, target);
        for (int i : ans) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : ans2) {
            System.out.print(i+" ");
        }
    }
}

package backtreking;

import java.util.ArrayList;
import java.util.List;

public class permutationList {
    // ================METHOD 1=============================
    static List<List<Integer>> printPermutation(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];
        helper(nums,ds,isValid,ans);
        return ans;
    }
    
    static void helper(int[] nums, List<Integer> ds, boolean[] isValid, List<List<Integer>> ans) {
        if(ds.size() == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ds.size(); i++) {
                list.add(ds.get(i));
            }
            ans.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(isValid[i] == false){
                ds.add(nums[i]);
                isValid[i] = true;
                helper(nums, ds, isValid, ans);
                isValid[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }

    // =============================method 2=======================
    static List<List<Integer>> printPermutation2(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        helper2(nums,0,ans);
        return ans;
    }
    
    static void helper2(int[] nums, int idx, List<List<Integer>> ans) {
        if(idx == nums.length-1){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <  nums.length; i++) {
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(i,idx,nums);
            helper2(nums, idx+1, ans);
            swap(i,idx,nums);
        }
    }

    static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(printPermutation2(arr));
    }
}

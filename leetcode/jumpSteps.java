package leetcode;

public class jumpSteps {
    static boolean canJump(int[] nums, int idx){
        // int steps = nums[idx];
        // if(nums.length == 1 || idx > nums.length || nums.length == steps) return true;
        // if(steps == 0 && nums[idx] != nums[nums.length - 1]) return false;
        // while(idx < steps){
        //     idx++;
        // }
        // return canJump(nums, idx);

        int i = 0, maxreach = 0;
        while(i < nums.length && i <= maxreach){
            maxreach = Math.max(i + nums[i], maxreach);
            i++;
        }
        if(i == nums.length) return true;

        return false;

        
    }
    public static void main(String[] args) {
        int[] arr = {2,0,0};
        System.out.println("Can jump to the last  : "+canJump(arr,0));
            
        
    }
}

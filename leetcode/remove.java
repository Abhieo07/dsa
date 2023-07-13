package leetcode;

import java.util.Scanner;

public class remove {
    static int removeElement(int[] nums, int val) {
        int cntVal = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                cntVal++;
                nums[i] = Integer.MAX_VALUE;
            }
        }
        return nums.length - cntVal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter ele");
        int[] nums = new int[n];

        for (int i = 0; i < args.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter ele to be removed: ");
        int k = sc.nextInt();
        System.out.println("there are: "+removeElement(nums,k));
        for (int i : nums) {
            System.out.print(i+" ");
        }
        
    }
}

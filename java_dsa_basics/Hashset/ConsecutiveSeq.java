package java_dsa_basics.Hashset;

import java.util.HashSet;

public class ConsecutiveSeq {
    static int longestConsecSeq(int[] arr){
        int max = 0;
        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            st.add(arr[i]);
        }
        for (Integer num : st) {
            if(!st.contains(num-1)) {
                int curNum = num;
                int currStreak = 1; //length of current consecutive seq
                while (st.contains(curNum + 1)) {
                    currStreak++;
                    curNum++;
                }
                max = Math.max(currStreak,max);
            }
        }

        return max;
    }

    static int maxPairAtTime(int[] nums){
        HashSet<Integer> table = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(table.contains(nums[i])) table.remove(nums[i]);
            else{
                table.add(nums[i]);
                max = Math.max(max,table.size());
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        int[] nums = {2,1,1,3,2,3};

        System.out.println("Longest Consecutive Sequence: "+longestConsecSeq(arr));
        System.out.println("Maximum pair on the table at a time: "+maxPairAtTime(nums));
    }
}

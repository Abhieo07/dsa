package leetcode;

public class removeDup {
    static int removeDuplicates(int[] nums) {
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    c++;
                    nums[i] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < nums.length - 1; i++){
            boolean flag = false;
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) return nums.length - c;
        }

        return nums.length - c;

    }

    /*
     * removes duplicates more than twice
     * arr [0,0,1,1,1,1,2,3,3] --> [0,0,1,1,2,3,3]
     */
    static int removeDuplicates2(int[] nums) {
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            int dup = 0;
            for(int j = i + 1; j < nums.length; j++){
                if(dup < 2 && nums[i] == nums[j]){
                    dup++;
                    
                    if(dup>=2){
                        c++;
                        nums[i] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        for(int i = 0; i < nums.length - 1; i++){
            boolean flag = false;
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) return nums.length - c;
        }

        return nums.length - c;
    }
    

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Removing duplicates: ");
        System.out.println(removeDuplicates(arr));
        for(int k : arr){
            System.out.println(k+",");
        }
        System.out.println("Removing duplicates more than twice like [0,0,1,1,1,1,2,3,3] --> [0,0,1,1,2,3,3] : ");
        System.out.println(removeDuplicates2(arr));
        for(int k : arr){
            System.out.println(k+",");
        }
    }
}


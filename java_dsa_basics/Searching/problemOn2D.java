package Searching;

public class problemOn2D {
    static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int st = 0, end = n*m-1;
        while(st <= end){
            int mid = st + (end - st) / 2;
            int midEle = matrix[mid/m][mid%m];
            if(midEle == target) return true;
            else if(midEle < target) {
                st = mid + 1;
            }
            else{
                end = mid -1;
            }
        }
        return false;
    }

    static boolean searchMatrix2(int[][] a, int target) {
        int n = a.length, m = a[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if(target == a[i][j]) return true;
            else if(target > a[i][j]) {
                i++;
            }
            else 
                j--;
        }

        return false;
    }

    static int peakIdx(int[] arr){
        int st = 0, end = arr.length - 1;
        int ans = -1;
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(arr[mid] < arr[mid + 1]){ // increasing slope
                st = mid + 1;
                ans = mid + 1;
            }
            else if(arr[mid] > arr[mid + 1]) // decreasing slope
                end = mid - 1;
        }

        return ans;
    }

    static int peakEle(int[] arr){
        int st = 0, end = arr.length - 1;
        while(st <= end){
            int mid = st + (end - st) / 2;

            if((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1]))
                return mid;
            else if(arr[mid] < arr[mid + 1]){ // uphill
                st = mid + 1;
            }
            else //downhill
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 10;
        int[][] b = {{2,4,6,8},{5,6,7,20},{7,11,13,25},{12,14,17,30}};
        int[] mount = {1,2,3,4,5,3,1,0};
        System.out.println(searchMatrix(a,target));
        System.out.println(searchMatrix2(b, target));
        // System.out.println(peakIdx(mount));
        System.out.println(peakEle(mount));
    }
}

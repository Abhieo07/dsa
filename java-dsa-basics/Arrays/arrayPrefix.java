import java.util.Scanner;

public class arrayPrefix {
    static void printArr(int arr[]){
        // for (int i : arr) {
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static int [] makePrefix(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        return arr;
    }
//brute force approach
    static int sumRange(int arr[], int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static int findArraySum(int arr[]){
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        return totalSum;
    }


    static boolean equalSumPartition(int[] arr){
        int totalSum = findArraySum(arr);

        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int suffixSum = totalSum - prefixSum;
            if(suffixSum == prefixSum)
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n+1];

        System.out.println("Enter "+n+" elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        // System.out.println("Enter "+n+" elements: ");
        // for (int i = 1; i <= n; i++) { //1 base indexing
        //     arr[i] = sc.nextInt();
        // }

        // System.out.println("Enter querry times: ");
        // int q = sc.nextInt();

        System.out.println("Original Array: ");
        printArr(arr);
        //equal partition
        System.out.println("Is equal sum partition? : "+equalSumPartition(arr));

        // makePrefix(arr);
        // while(q > 0){
        //     System.out.println("Enter range l and r: ");
        //     int l = sc.nextInt();
        //     int r = sc.nextInt();

        //     //using prefix sum---> sum = prefixSum(r)-prefixSum(l)
        //     System.out.println("Sum from "+l+" to "+r+": "+(arr[r]-arr[l-1]));

        //     // System.out.println("Sum from "+l+" to "+r+": "+sumRange(arr, l, r)); //it is a brute force approach
        //     q--;
        // }

        // System.out.println("Prefix Sum of array: ");
        // makePrefix(arr);
        // printArr(arr);

    }
}

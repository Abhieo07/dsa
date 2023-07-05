import java.util.Arrays;
import java.util.Scanner;

public class arrayQues {

    static int count(int arr[], int x) {
        int count = 0;

        for (int i : arr) {
            if(i == x)
            ++count;
        }

        return count;
    }

    static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static int lastOcc(int arr[], int x) {
        int in = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x)
            in = i;
        }

        return in;
    }

    static int strictCount(int arr[], int x) {
        int count = 0;
        for (int i : arr) {
            if(i > x)
            count ++;
        }
        return count;
    }

    static boolean checkSorted(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i - 1])
            return false;
        }

        return true;
    }

    static int[] smallestAndLargest(int arr[]) {
        Arrays.sort(arr);
        int[] ans = {arr[0], arr[arr.length-1]};
        return ans;
    }

    static int[] kthSmallestAndLarges(int arr[], int k) {
        Arrays.sort(arr);
        int ans[] = {arr[k-1], arr[arr.length-k]};
        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter "+n+" elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //count number of occurence in array
        // System.out.println("Enter number to count: ");
        // int a = sc.nextInt();
        // System.out.println("Total occurrence of "+a+" is: "+count(arr, a));
        // System.out.println("Original array: ");
        // printArr(arr);
        // System.out.println("Last index of "+a+" is: "+lastOcc(arr, a));
        // System.out.println("numbers strictly greater than "+a+" is: "+strictCount(arr, a));
        // System.out.println("Is given array sorted: "+checkSorted(arr));
        // int [] ans = smallestAndLargest(arr);
        // System.out.println("Smallest "+ans[0]+" and largest "+ans[1]);

        System.out.println("Enter value of k to get Kth smallest and largest: ");
        int k = sc.nextInt();
        int Kth[] = kthSmallestAndLarges(arr, k);
        System.out.println("Kth smallest: "+Kth[0]);
        System.out.println("Kth largest: "+Kth[1]);

        
    }
}

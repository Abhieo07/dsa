// TWO POINTER APPROACH IN ARRAY

import java.util.Scanner;

public class arrayTwoPointer {
    static void swap(int arr[], int st, int en){
        while(st < en) {
            arr[st] = arr[st] + arr[en];
            arr[en] = arr[st] - arr[en];
            arr[st] = arr[st] - arr[en];
            st++;
            en--;
        }
    }

    static void printArr(int arr[]){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    //Sort array of only 0s and 1s
    static void sortZeroOnes(int arr[]) {
        int zeros = 0;
        //count number of zeroes
        for (int i : arr) {
            if(i == 0)
            zeros++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(i < zeros)
            arr[i] = 0;
            else
            arr[i] = 1;
        }
    }

    //method 2 for sortZeroesOnes
    static void swapZeroOnes(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            if(arr[left] != 0 && arr[right] != 1){
                swap(arr, left, right);
                left ++;
                right --;
            }
            if(arr[left] == 0)
            left++;
            if(arr[right] == 1)
            right --;
        }
    }
    
    //sort array using even first
    static void sortParity(int arr[]) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            if(arr[left] % 2 == 1 && arr[right] % 2 == 0){
                swap(arr, left, right);
                left ++;
                right --;
            }
            if(arr[left] % 2 == 0)
            left++;
            if(arr[right] % 2 == 1)
            right --;
        }
    }

    //sorted array in non-dec order return sorted of square of each element in no-dec order
    static int [] sortSquare(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int ans[] = new int [arr.length];
        int k = 0;

        while(left <= right){
            if(Math.abs(arr[left]) > Math.abs(arr[right])) {
                ans[k++] = arr[left] * arr[left];
                left ++;
            } else {
                ans[k++] = arr[right] * arr[right];
                right--;
            }
        }
        swap(ans, 0,ans.length-1);
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

        // sortZeroOnes(arr);
        // swapZeroOnes(arr);
        // sortParity(arr);
        System.out.println("Original array: ");
        printArr(arr);
        int ans[] = sortSquare(arr);
        System.out.println("After sorting: ");
        printArr(ans);

    }
}

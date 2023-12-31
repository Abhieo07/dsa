package Sorting;

import java.util.Scanner;

public class countSort {
    static void printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if(i > max)
            max = i;
        }
        return max;
    }

    static void basicCountSort(int[] arr){
        // find the largest element of the array
        int max = findMax(arr);
        int count[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }
    }

    //using prefixSum
    static void countSortAl(int[] arr){
        int[] output = new int[arr.length];
        int max = findMax(arr); // find the largest element of the array
        int count[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) { // make frequency array
            count[arr[i]]++;
        }
        // make prefix sum array of count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // find index of each element in a original array and put it in output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = count[arr[i]] - 1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }
        // copy all elements of output to original array
        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // basicCountSort(arr);
        countSortAl(arr);
        System.out.println("After sorting: ");
        printArr(arr);
        
    }
}

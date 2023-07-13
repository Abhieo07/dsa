package Sorting;

import java.util.Scanner;

public class radixSort {
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

    static void countSort(int[] arr, int place){
        int[] output = new int[arr.length];
        int count[] = new int[10];
        for (int i = 0; i < arr.length; i++) { // make frequency array
            count[(arr[i]/place)%10]++;
        }
        // make prefix sum array of count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // find index of each element in a original array and put it in output array
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = count[(arr[i]/place)%10] - 1;
            output[idx] = arr[i];
            count[(arr[i]/place)%10]--;
        }
        // copy all elements of output to original array
        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
        }
    }

    static void radixSortAl(int[] arr){
        int max = findMax(arr);

        // aplly counting sort to sort elements based on place value
        for (int place = 1; max/place > 0; place*=10) {
            countSort(arr, place);
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
        radixSortAl(arr);
        System.out.println("After sorting: ");
        printArr(arr);
        
    }

}

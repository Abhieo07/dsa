package Sorting;

import java.util.Scanner;

public class sorting {

    static void printArr(int arr[]){
        for (int i : arr) {
            System.out.print(i+" ");
        }System.out.println();
    }

    static void bubbleSort(int[] arr) { // space: O(1) time: O(n2) best case is improved using flag O(n)
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false; // has any swapping happened
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if(arr[j] > arr[j+1]){
                    arr[j+1] = arr[j+1] + arr[j];
                    arr[j] = arr[j+1] - arr[j];
                    arr[j+1] = arr[j+1] - arr[j];
                    flag = true; // some swap has happened
                }
            }

            if(!flag) return; // have any swaps happend?
        }
    }

    static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) { // i represent the current index

            // find min ele in unsorted array
            int idx_min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[idx_min]){
                    idx_min = j;
                }
            }

            // swap current ele and minimum element
            if(idx_min != i){
                // int temp = arr[i];
                // arr[i] = arr[idx_min];
                // arr[idx_min] = temp;
                arr[idx_min] = arr[idx_min] + arr[i];
                arr[i] = arr[idx_min] - arr[i];
                arr[idx_min] = arr[idx_min] - arr[i];
            }
            
        }
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elemments: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // System.out.println("Sorted using bubble sort");
        // bubbleSort(arr);
        // printArr(arr);
        System.out.println("Sorted using Selection sort");
        selectionSort(arr);
        printArr(arr);
    }

}

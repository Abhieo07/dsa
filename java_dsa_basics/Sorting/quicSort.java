package Sorting;

import java.util.Scanner;

public class quicSort {
    static void printArr(int arr[]){
        for (int i : arr) {
            System.out.print(i+" ");
        }System.out.println();
    }

    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int partition(int[] arr, int st, int end){
        int pivot = arr[st];

        // int rand = (int)(Math.random()*(end - st)) + st;
        // int pivot = arr[rand]; // to avoid worct case e.g [1,2,3,4,5,6,7]

        int cnt = 0;
        for (int i = st + 1; i <= end; i++) {
            if(arr[i] < pivot)
                cnt++;
        }

        int pivotIndex = st + cnt; // st can be > 0 thus we had to add st in cnt
        swap(arr, st, pivotIndex);

        int i = st, j = end;
        while (i < pivotIndex && j > pivotIndex) {
            while(arr[i] <= pivot) 
                i++;
            while(arr[j] > pivot)
                j--;
            if(i < pivotIndex && j > pivotIndex){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    static void quickSort(int[] arr, int st, int end){
        if(st >= end) return;

        int pi = partition(arr,st,end);
        quickSort(arr, st, pi - 1);
        quickSort(arr, pi + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements in array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr,0,n-1);
        System.out.println("Array after doing quick sort: ");
        printArr(arr);
    }
}

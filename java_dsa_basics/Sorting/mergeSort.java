package Sorting;

import java.util.Scanner;

public class mergeSort {
    static void printArr(int arr[]){
        for (int i : arr) {
            System.out.print(i+" ");
        }System.out.println();
    }

    static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        int i,j,k;
        for(i = 0; i < n1; i++) left[i] = arr[l+i];
        for(j = 0; j < n2; j++) right[j] = arr[mid+1+j];

        i = 0;
        j = 0;
        k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
            
        }

        while(i < n1)
            arr[k++] = left[i++];
        
        while(j < n2)
            arr[k++] = right[j++];
    }

    static void mergeSortAlgo(int[] arr, int l, int r) {
        if(l >= r) return;

        int mid = (l + r) / 2;
        mergeSortAlgo(arr, l, mid);
        mergeSortAlgo(arr, mid + 1, r);
        merge(arr,l,mid,r);

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

        mergeSortAlgo(arr,0,n-1);
        System.out.println("Array after doing merge sort: ");
        printArr(arr);
    }

    
}

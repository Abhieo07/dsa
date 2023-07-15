package Sorting;

import java.util.Scanner;

public class prob1 {
    static void printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    // given sorted array have few swapped element sort it in linear time
    static void sort1(int[] arr){
        int x = -1, y = -1;
        if(arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i - 1] > arr[i]){
                if(x == -1) //1st conflict
                    {x = i - 1;
                    y = i;}
                else 
                    y = i; // 2nd conflict
            }
        }
        if(x != y){
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
    }

    /*given an array of positive and neagtive integers, segregate them 
    in linear time and constant space. the output should print all -ve nums
    followed by +ve nums
    */

    static void sort2(int[] arr){
        int l = 0;
        int r = arr.length - 1;
        while(l < r){
            while(arr[l] < 0){
                l++;
            }
            while(arr[r] >= 0){ //0s are at the +ve number side
                r--;
            }
            if(l < r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }

    /*Given an array of size N containing only 0s, 1s, 2s;
     * Sort the array in ascending order
     */
// using count sort algo
    static void Sort012(int[] arr){
        int count0s = 0, count1s = 0, count2s = 0;
        for (int i : arr) {
            if(i == 0)
                count0s++;
            else if(i == 1)
                count1s++;
            else
                count2s++;
        }
        int k = 0;
        while(count0s>0){
            arr[k++] = 0;
            count0s--;
        }
        while(count1s>0){
            arr[k++] = 1;
            count1s--;
        }
        while(count2s>0){
            arr[k++] = 2;
            count2s--;
        }

    }

    static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    // method 2
    static void sort012(int[] arr){
        int lo = 0, mid = 0, hi = arr.length - 1;
        // [0, low-1] --> 0
        // [low,mid-1] --> 1
        // [mid, high] --> unknown
        // [hi+1,n-1] --> 2
        while (mid <= hi) {
            if(arr[mid] == 0){
                swap(arr, mid, lo);
                mid++;
                lo++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else {
                swap(arr, mid, hi);
                hi--;
            }
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
        // sort1(arr);
        // sort2(arr);
        sort012(arr);
        System.out.println("After sorting: ");
        printArr(arr);
        
    }
}

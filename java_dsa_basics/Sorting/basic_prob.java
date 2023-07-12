package Sorting;

import java.util.Scanner;

public class basic_prob {
    static void printArr(int arr[]){
        for (int i : arr) {
            System.out.print(i+" ");
        }System.out.println();
    }

    static void sort0sAtEnd(int arr[], int idx){ 
        boolean flag = false;
        for (int i = 0; i < arr.length - idx - 1; i++) {
            if(arr[i] == 0 && arr[i + 1] != 0){
                arr[i] = arr[i] + arr[i + 1];
                arr[i + 1] = arr[i] - arr[i + 1];
                arr[i] = arr[i] - arr[i + 1];
                flag = true;
            }
        }
        if(!flag || idx >= arr.length - 1) return;
        sort0sAtEnd(arr, idx + 1);
    }

    // using selection sort
    static void sortLex(String[] fruits){
        for (int i = 0; i < fruits.length - 1; i++) {
            int idx_min = i;
            for (int j = i + 1; j < fruits.length; j++) {
                if(fruits[j].compareTo(fruits[idx_min])<0){
                    idx_min = j;
                }
            }
            // swap fruits of idx_min and curr
            String temp = fruits[i];
            fruits[i] = fruits[idx_min];
            fruits[idx_min] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in array: ");
        int n = sc.nextInt();
        System.out.println("Enter elements in array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort0sAtEnd(arr, 0);
        System.out.println("After sorting 0s to the end of the array");
        printArr(arr);
        String[] fruits = {"kiwi", "apple","papaya","mango"};
        sortLex(fruits);
        for (String string : fruits) {
            System.out.println(string+" ");
        }

    }

}

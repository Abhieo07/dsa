package Searching;

import java.util.Scanner;

public class BinarySearch {
    static void printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static boolean binarySearch(int []arr,int x,int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        if(lo > hi) return false;
        if(arr[mid] == x) return true;

        if(x < arr[mid])
            return binarySearch(arr, x, lo, mid - 1);
        return binarySearch(arr, x, mid + 1, hi);
    }

    // first occurence of a given element in sorted array
    static int firstOcc(int[] arr, int target, int lo, int hi, int fo){
        if(lo > hi) return fo;

        int mid = lo + (hi - lo)/2;
        if(arr[mid] == target){
            fo = mid;
            return firstOcc(arr, target, lo, mid - 1, fo);
        }
        if(target < arr[mid])
            return firstOcc(arr, target, lo, mid - 1, fo);
        return firstOcc(arr, target, mid + 1, hi,fo);
    }

    static int squareRoot(int num){
        int lo = 0, hi = num;
        int ans = 0;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(mid * mid == num) 
                return mid;
            else if(mid * mid > num)
                hi = mid - 1;
            else{
                lo = mid + 1;
                ans = mid; // for non perfect square we will return mid * mid < num
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter sorted elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" exists "+binarySearch(arr, i, 0, n - 1));
            System.out.println("1st occurence of "+i+" is: "+firstOcc(arr, i, 0, n - 1,-1));
            System.out.println("Square root of "+5*i+" is: "+squareRoot(5*i));
            System.out.println();
        }
        
    }
}

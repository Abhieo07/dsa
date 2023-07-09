package Recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class array {
    static void traverse(int arr[], int idx){
        if(idx == arr.length){ // if id written idx == arr.length - 1 then i had to print the last element
            return; // idx = n -->last element
        }
        System.out.print(arr[idx]+" "); // print the very first element
        traverse(arr, idx + 1); // call itself to print next element
    }

    static int maxVal(int arr[], int idx){
        if(idx == arr.length - 1) // if arr has only one element
            return arr[idx];

        int max = maxVal(arr, idx+1);
        if(max < arr[idx])
            return arr[idx];
        
        return max;
    }

    static int sumArr(int arr[], int idx){
        if(idx == arr.length - 1) // if arr has only one element
            return arr[idx];
    
        return arr[idx] + sumArr(arr, idx+1);
    }

    static boolean exist(int arr[], int x, int idx){
        if(idx == arr.length)
            return false;

        if(arr[idx] == x)
            return true;

        return exist(arr, x, idx + 1);
    }

    static int indexOf(int arr[], int x, int idx){
        if(idx == arr.length)
            return -1;

        if(arr[idx] == x)
            return idx;

        return indexOf(arr, x, idx + 1);
    }

    static void indeices(int arr[], int x, int idx){
        if(idx == arr.length) return;

        if(arr[idx] == x)
            System.out.print(idx+" ");
        indeices(arr, x, idx + 1);
    }

    static ArrayList<Integer> indeicesList(int arr[], int x, int idx){
        ArrayList<Integer> ans = new ArrayList<>();
        if(idx >= arr.length) return ans;

        if(arr[idx] == x)
            ans.add(idx);

        return indeicesList(arr, x, idx + 1);
    }

    static boolean isSorted(int arr[], int idx){ // idx 1
        if(idx == arr.length - 1) return true;

        if(arr[idx] > arr[idx - 1])
            return isSorted(arr, idx + 1);
        
        return false;
    }

    static int lastIndex(int arr[], int x, int idx){
        if(idx == arr.length)
            return -1;

        int l = indexOf(arr, x, idx + 1);
        if(arr[idx] == x && idx > l)
            return idx;
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array: ");
        int n = sc.nextInt();
        System.out.println("Enter elements: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Traverse: ");
        traverse(arr, 0);
        System.out.println();
        System.out.println("Maximum in given array: "+maxVal(arr, 0));
        System.out.println("Sum of given array: "+sumArr(arr, 0));
        System.out.println("Enter element to find");
        int x = sc.nextInt();
        System.out.println("Exsts: "+exist(arr, x, 0));
        System.out.println("index of given array: "+indexOf(arr, x, 0));
        System.out.println("indices of "+x);
        indeices(arr, x, 0);
        ArrayList<Integer> a = new ArrayList<>();
        a = indeicesList(arr, x, 0);
        System.out.println(a);
        System.out.println("Is sorted? "+isSorted(arr, 1));
        System.out.println("last index of given array: "+lastIndex(arr, x, 0));
    }
}

//BASIC QUESTIONS IN ARRAYS

import java.util.Scanner;

public class arrayQues2 {

    //total number of pair in array whoose sum is given number
    static int pairSum(int [] arr, int target) {
        int pair = 0;
        for (int i = 0; i < arr.length; i++) {//first number
            for (int j = i + 1; j < arr.length; j++) {//second number
                if(arr[i] + arr[j] == target)
                pair++;
            }
        }
        return pair;
    }

    //number of triplet whoose sum is equal to the given number

    static int tripletSum(int arr[], int target) {
        int triplet = 0;
        for (int i = 0; i < arr.length; i++) { //first number
            for (int j = i+1; j < arr.length; j++) {//for 2nd number
                for (int j2 = j + 1; j2 < arr.length; j2++) {//for 3rd number
                    if(arr[i] + arr[j] + arr[j2] == target)
                    triplet++;
                }
            }
        }

        return triplet;
    }

    //to find unique number in array

    static int uniqueNum(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    arr[i] = -1;
                    arr[j] = -1;
                }
            }
        }
        int unique = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0)
            unique = arr[i];
        }

        return unique;
    }

    static int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if(i > max)
            max = i;
        }
        return max;
    }

    static int secMax(int arr[]) {
        int mx = findMax(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == mx)
            arr[i] = Integer.MIN_VALUE;
        }
        int ans = findMax(arr);
        return ans;
    }

    static int firstDup(int arr[]) {
        for (int i = 0; i < arr.length; i++) { // first number
            for (int j = i + 1; j < arr.length; j++) { //2nd number
                if(arr[i] == arr[j])
                return arr[j];
            }
        }

        return -1;
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
        // System.out.println("Enter target: ");
        // int t = sc.nextInt();
        // System.out.println("Total pair sum: "+pairSum(arr, t));
        // System.out.println("Total triplet: "+tripletSum(arr, t));
        // System.out.println("Unique number: "+uniqueNum(arr));
        // System.out.println("Maximum of array is: "+findMax(arr));
        // System.out.println("2nd Maximum of array is: "+secMax(arr));
        System.out.println("First duplicate in array: "+firstDup(arr));
    }
}

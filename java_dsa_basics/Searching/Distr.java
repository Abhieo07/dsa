package Searching;

import java.util.Scanner;

public class Distr {

    static boolean isDivisionPosible(int[] arr, int m, int maxAllowed) {
        int students = 1;
        int  choc = 0; // number of chocolates current student has

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxAllowed) return false;
            if(choc + arr[i] <= maxAllowed){
                choc += arr[i];
            }
            else{
                students++;
                choc = arr[i];
            }
        }
        // if(students <= m)
        //     return true;

        return students <= m;
    }

    static int distributeChocolates(int[] arr, int m){
        if(arr.length < m) return -1;
        int ans = 0, st = 1, end = (int)1e9;

        while(st <= end){
            int mid = st + (end - st) / 2;
            if(isDivisionPosible(arr, m, mid)){ //check
                ans = mid;
                end = mid - 1;
            }else {
                st = mid + 1;
            }
        }
        return ans;
    }

    static int raceTrack(int[] a, int k){
        if(a.length < k) return -1;
        int ans = -1;
        int st = 1, end = (int)1e9;
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(divPossible(a,k,mid)) { // can k kids be placed such that no 2 kids have lesser distance than mid
                ans = mid;
                st = mid + 1;
            }
            else 
                end = mid - 1;
        }
        return ans;
    }

    static boolean divPossible(int[] arr, int k, int dist) {
        int kidsPlaced = 1;
        int lastKid = arr[0]; // minimum distance between kids and the current kid

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - lastKid >= dist){
                kidsPlaced++;
                lastKid = arr[i];
            }
        }

        return kidsPlaced >= k;
    }

    public static void main(String[] args) {
        int[] a = {12,34,67,90};
        int m = 2;
        
        System.out.println(distributeChocolates(a, m));
        int[] b = {1,2,4,8,9};
        int k = 3;
        System.out.println(raceTrack(b, k));
    }
}

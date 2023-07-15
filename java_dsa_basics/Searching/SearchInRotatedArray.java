package Searching;

import java.util.Scanner;

public class SearchInRotatedArray {
    static int finMinIndex(int arr[]){
        int st = 0, end = arr.length - 1;
        int ans = -1;
        while(st <= end){
            int mid = st + (end - st) / 2;

            if(arr[mid] > arr[arr.length - 1]){
                st = mid + 1;
            }
            else if(arr[mid] <= arr[arr.length - 1]){
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    static int getIndex(int arr[], int target){
        int st = 0, end = arr.length - 1;
        
        while(st <= end){
            int mid = st + (end - st) / 2;

            if(arr[mid] == target){
                return mid;
            }
            else {
                if(arr[mid] < arr[end]){ // mid to end is sorted
                
                    if(target > arr[mid] && target <= arr[end])  st = mid + 1;
                    else end = mid - 1;
                }
                else{
                    //st to mid is sorted
                    if(target >= arr[st] && target < arr[mid]) end = mid + 1;
                    else st = mid + 1;
                }
            }
        }
        return -1;
    }

    static int getIndexDup(int arr[], int target){
        int st = 0, end = arr.length - 1;
        
        while(st <= end){
            int mid = st + (end - st) / 2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[st] == arr[mid] && arr[mid] == arr[end]){
                st++;
                end--;
            }
            else {
                if(arr[mid] <= arr[end]){ // mid to end is sorted
                
                    if(target > arr[mid] && target <= arr[end])  st = mid + 1;
                    else end = mid - 1;
                }
                else{
                    //st to mid is sorted
                    if(target >= arr[st] && target < arr[mid]) end = mid + 1;
                    else st = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int[] a = {3,4,5,1,2};
        int[] b = {1,1,1,2,2,3,1};
        System.out.println(finMinIndex(a));
        int target = 2;
        System.out.println(getIndex(a, target));
        System.out.println(getIndexDup(b, target));
        
    }
}

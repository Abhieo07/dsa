package Recurssion;

import java.util.ArrayList;
import java.util.Scanner;

public class subSeq {

    static ArrayList<String> getSSQ(String s){ // time:O(n2),space:O(2^n)
        ArrayList<String> ans = new ArrayList<>();
        if(s.length() == 0){
            ans.add("");
            return ans;
        } 

        char cur = s.charAt(0); // a
        ArrayList<String> subAns = getSSQ(s.substring(1)); // ["bc","b","c"," "]

        // subAns = ["bc","b","c"," "]
        // ans = ["bc","b","c"," ","abc","ab","ac","a"]
        for (String string : subAns) {
            ans.add(string); // bc
            ans.add(cur + string); // abc
        }
        return ans;
    }

    // time:O(2^n),space:O(n2), include-exclude approach
    static void printSSQ(String s, String currAns){ // s = "abc", currAns = " "  
        if(s.length() == 0){
            System.out.print(currAns+",");
            return;
        }

        char curr = s.charAt(0); // a
        String remStr = s.substring(1); // bc

        // curr -> chooses to be a part of currAns
        printSSQ(remStr, currAns + curr); // bc, ""+a --> bc, a

        // curr -> does not choose to be part of currAns
        printSSQ(remStr, currAns); // bc,""
    }

    static void subsetSum(int[] arr,int curSubSum, int idx){ // curusbans = 0
        if(idx >= arr.length){
            System.out.print(curSubSum+",");
            return;
        }
        subsetSum(arr, curSubSum + arr[idx], idx + 1); // include
        subsetSum(arr, curSubSum, idx + 1); // exclude

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to get subsequence: ");
        String str = sc.next();
        System.out.println("Sub string of "+ str+" is: "+getSSQ(str));
        System.out.println("Print sub string of "+ str+"  is:");
        printSSQ(str, "");
        System.out.println();
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements to get subset sum: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("subset sum: ");
        subsetSum(arr, 0, 0);
    }
}

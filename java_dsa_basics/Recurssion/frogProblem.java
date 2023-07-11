package Recurssion;

import java.util.Scanner;

public class frogProblem {
    // frog jump minimum cost to reach n-1 th stone by doin i+1 or i+2 jumps

    static int minCost(int [] h, int idx){  // time: O(2^n)
        if(idx == h.length - 1) return 0;
        int opt1 = Math.abs(h[idx] - h[idx + 1]) + minCost(h,  idx + 1);
        if(idx == h.length - 2) return opt1;
        int opt2 = Math.abs(h[idx] - h[idx + 2]) + minCost(h,  idx + 2);

        return Math.min(opt1, opt2);
    }

    // time: O(n.4^n)  d : no of digits
    static void combination(String dig, String[] kp ,String curAns){ // 253
        if(dig.length() == 0){
            System.out.print(curAns+",");
            return;
        }
        int curNum = dig.charAt(0) - '0'; // to convert dig of string to number
        String curChoices = kp[curNum]; // abc for 2
        
        for (int i = 0; i < curChoices.length(); i++) {
            combination(dig.substring(1), kp, curAns + curChoices.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of stones: ");
        int n = sc.nextInt();
        int [] h = new int[n];
        System.out.println("Enter value of each stones: ");
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        System.out.println("Minimum cost: "+minCost(h, 0));

        System.out.println("Enter numbers of 2-9");
        String str = sc.next();
        // kp[7] = "pqrs"
        String kp[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; // to map char with numbers from 0 to 9
        //             0   1   2     3     4     5     6      7     8      9
        combination(str, kp, "");
    }
}

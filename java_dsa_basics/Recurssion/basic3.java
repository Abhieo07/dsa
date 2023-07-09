package Recurssion;

import java.util.Scanner;

public class basic3 {

    static void multiKtimes(int num, int k) { //O(k)
        if(k == 1){
            System.out.print(num+" ");
            return;
        }
        multiKtimes(num, k - 1);
        System.out.print(k*num+" ");
    }

    static int sumWithAltSign(int n){ // O(n)
        if(n == 1)
        return 1;
        if(n % 2 == 0)
            return sumWithAltSign(n-1) - n;

        return n + sumWithAltSign(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number and k: ");
        int num = sc.nextInt();
        int k = sc.nextInt();
        multiKtimes(num, k);
        System.out.println();
        System.out.println("Enter n to get alternate sign sum: ");
        int n = sc.nextInt();
        System.out.println("sum: "+sumWithAltSign(n));;
    }

}

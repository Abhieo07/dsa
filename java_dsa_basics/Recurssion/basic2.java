package Recurssion;

import java.util.Scanner;

public class basic2 {
    static long sumOfDigits(long n){
        if(n >= 0 && n <= 9)
        return n; // for single digit sum id n
        return n%10 + sumOfDigits(n / 10); //if n = 1234 then 4 + sumOfDigits(123)
    }

    static long countDigit(long n){ // O(no of digits)
        if(n <= 9 && n >= 0)
        return 1;
        return 1 + countDigit(n / 10);
    }

    static int power(int p, int q){ // O(q)
        if(q == 0)
        return 1;
        return p * power(p,q-1);

    }

    static int powerAlt(int p, int q){  // O(logq)
        if(q == 0)
        return 1;
        int smallPow = power(p, q / 2);
        if(q % 2 == 0)
            return smallPow * smallPow;
        return p * smallPow * smallPow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to find sum of its digits");
        long n = sc.nextLong();
        System.out.println("Sum: "+ sumOfDigits(n));
        System.out.println("Count: "+ countDigit(n));
        System.out.println("Enter p and q: ");
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(p+" power raised to "+q+" is: "+powerAlt(p, q));
    }
}

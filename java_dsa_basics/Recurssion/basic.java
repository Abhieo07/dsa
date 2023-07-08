package Recurssion;

import java.util.Scanner;

public class basic {
    static void printIncreasing(int n){  
        // base case
        if(n == 1){
            System.out.print(n);
            return;
        }
        // assume it will print 1,2,3,,,n-1
        printIncreasing(n - 1);
        //sout(n)
        System.out.print(" "+n);
    }

    static void printDescreasing(int n){
        if(n < 1){
            System.out.println("Invalid Input ");
            return;
        }
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDescreasing(n - 1);
    }

    static int factorial(int n){
        if(n == 0)
        return 1;
        return n * factorial(n-1);
    }

    static int fibonacci(int n){
        if(n == 0 || n == 1)
        return n;
        int f = fibonacci(n - 2);
        int fib = fibonacci(n-1);
        return f + fib; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();

        System.out.println("Increasing Order: ");
        printIncreasing(n);
        System.out.println();
        System.out.println("Decreasing Order: ");
        printDescreasing(n);
        for (int i = 1; i <= n; i++) {
            System.out.println("Factorial of "+i+" is: "+factorial(i));
            System.out.println("Fibonacci of "+i+" is: "+fibonacci(i));
        }
        
    }    
}

package Recurssion;

import java.util.Scanner;

public class basic4 {
    // brute force aproach
    static int gcd(int x,int y){
        int n = 0;
        if(x>y)
            n=y;
        n=x;
        for (int i = n; i > 1; i--) {
            if(x%i == 0 && y%i == 0)
            return i;
        }
        return 1;
    }

    // iterative approach
    static int gcd1(int x, int y){
    
        while (x % y != 0) {
            int rem = x % y;
            x = y;
            y = rem;
        }

        return y;
    }

    /*
     * Euclids algorithm
     * gcd(x,y)=gcd(y,x%y)
     * gcd(x,0)=x
     */
    static int gcd3(int x,int y){ // O(logn)
        if(y == 0)
            return x;

        return gcd(y, x % y);
    }
    // gcd(x,y)*lcm(x,y) = x * y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of x and y to get GCD: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("gcd using brute force approach: "+gcd(x, y));
        System.out.println("gcd using iterative approach: "+gcd1(x, y));
        System.out.println("gcd using Euclids algorithm: "+gcd3(x, y));
        System.out.println("LCM : "+(x*y) / gcd3(x, y));
    }
}

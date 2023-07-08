import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class loop {

    static void NumberOfDigits() {
         // count number of digits
        System.out.println("Enter number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = n;

        int digit = 0;
        while (n > 0) {
            n /= 10;
            digit ++;
        }

        System.out.println("Number of digit in given number "+m+" are: "+digit);
    }

    static int SumOfDigits(int n) {
        int sum = 0;

        while(n>0) {
            sum += n%10;
            n /=10;
        }

        return sum;
    }

    static int Reverse(int n) {
        int rev = 0;
         
        while(n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        
        return rev;
    }

    static int sum(int n) {
        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            if( i % 2 == 0)
            ans -= i;
            else
            ans += i;
            
        }

        return ans;
        
    }

    static int factorial(int n) {
        // int fact = 1;
        // for (int i = 1; i <= n; i++) {
        //     fact *= i;
        //System.out.println("Factorial of "+i+" "+ fact);
        // }

        // return fact;

        if(n == 0)
        return 1;
        else
        return n * factorial(n-1);
    }

    static int power(int a, int b) {
        // int pow = 1;

        // for (int i = 0; i < b; i++) {
        //     pow *= a;
        // }
        // return pow;

        //using recursion
        if(a == 0)
        return 0;
        else if(b==0 || a== 1)
        return 1;
        else 
        return a*power(a,b-1);
        
    }

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
    //    System.out.println("Enter n");
    //    int n = sc.nextInt();
       System.out.println("Enter a and b");
       int a = sc.nextInt();
       int b = sc.nextInt();
       
       //NumberOfDigits();

       //System.out.println("Sum of digits in "+ n +" = "+SumOfDigits(n));
       //System.out.println("Reverse "+ n +" = "+Reverse(n));
       //System.out.println("Sum of series "+ n +" = "+sum(n));
       //System.out.println("Factorial of "+ n +" = "+factorial(n));
       System.out.println(a+" raise to power of "+b + "= "+power(a, b));

    }
}

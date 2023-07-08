import java.util.Scanner;

public class basic {
    static void printIncreasing(int n){  
        // base case
        if(n == 1){
            System.out.println(n);
            return;
        }
        // assume it will print 1,2,3,,,n-1
        printIncreasing(n - 1);
        //sout(n)
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();

        printIncreasing(n);

    }    
}

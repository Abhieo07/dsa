import java.util.Scanner;

public class nestedLoops {
    
    static void rect(int r, int c) {
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {
                System.out.print("*");
            }
            System.out.println();
            
        }
    }
    
    static void voidRect(int r, int c) {
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {
                if(j == 0 || j == c-1 || i == r-1 || i == 0)
                System.out.print("*");
                else
                System.out.print(" ");
            }
            System.out.println();
            
        }
    }

    static void tri(int h) {
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void invertedTri(int h) {
        // for (int i = 1; i <= h; i++) {
        //     for (int j = 1; j <= h+1-i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        for (int i = h; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void piramid(int h) {
        for (int i = 1; i <= h; i++) {//traversing over rows

            //print r-i spaces
            for (int j = i; j <= h - 1; j++) {
                System.out.print(" ");
            }
            // print 2*i - i
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void numRect(int r, int c) {
        for (int i = 1; i <= r; i++) {
            for (int j = i; j <=c ; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void rectOneTwo(int r, int c) {
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {
                if((i+j)%2 == 0)
                System.out.print("1");
                else
                System.out.print("2");
            }
            System.out.println();
            
        }
    }

    static void numTri(int r) {
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void numPiramid(int r) {
        for (int i = 1; i <= r; i++) {//traversing over rows

            //print r-i spaces
            for (int j = i; j <= r - 1; j++) {
                System.out.print(" ");
            }
            // print 1 to i
            for (int j = 1; j <= i; j++) {
                System.out.print(j);   
            }
            //print i-1 to 1
            for (int j = i-1; j >=1; j--) {
                System.out.print(j);   
            }

            System.out.println();
        }
    }

    static void hollowPiramid(int h) {
        for (int i = 1; i <= h; i++) {//traversing over rows

            //print r-i spaces
            for (int j = i; j <= h - 1; j++) {
                System.out.print(" ");
            }
            // print 2*i - i
            for (int j = 1; j <= 2*i-1; j++) {
                if(i == 1 || i == h || j == 2*i-1 || j==1)
                System.out.print(i);
                else
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //RECTANGULAR PATTERN
        // System.out.println("Enter value of rows and columns ");
        // int r = sc.nextInt();
        // int c = sc.nextInt();
        //rect(r, c);
        //voidRect(r, c);

        //TRIANGULAR PATTERN
        // System.out.println("Enter value of height ");
        // int h = sc.nextInt();
        //tri(h);
        //invertedTri(h);
        //piramid(h);

        //NUMERICAL RECTANGUALR PATTERN
        // System.out.println("Enter value of rows and columns ");
        // int r = sc.nextInt();
        // int c = sc.nextInt();
        //numRect(r, c);
        // rectOneTwo(r, c);

        //TRIANGULAR PATTERN
        System.out.println("Enter value of height ");
        int r = sc.nextInt();
        //numTri(r);
        //numPiramid(r);
        hollowPiramid(r);

    }

}

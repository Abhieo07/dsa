import java.util.Scanner;

public class matrix {

    static void printArr(int [][] arr){

        for (int i = 0; i < arr.length; i++) { //for rows
            for (int j = 0; j < arr[i].length; j++) { //for columns
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void reverseArray(int [] arr){
        int i = 0, j = arr.length - 1;

        while(i < j){
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
    //    Transpose t = new Transpose();
        PascalTri p = new PascalTri();

    }
}

class Transpose {

    static int[][] transpose(int [][] arr, int r, int c){
        int [][] ans = new int[c][r];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                ans[i][j] = arr[j][i];
            }
        }
        return ans;
    }

    //this method is only applicabe to square matrix
    static void transposeInplace(int[][] arr, int r, int c) {
        for (int i = 0; i < c; i++) {
            for (int j = i; j < r; j++) {
                //swap matrix[i][j] and matrix[j][i]
                // arr[i][j] = arr[i][j] + arr[j][i];
                // arr[j][i] = arr[i][j] - arr[j][i];
                // arr[i][j] = arr[i][j] - arr[j][i];
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    //rotate 90 to clockwise 1st row becomes last col and so on
    //it can be achieved using reverse on each row of tranposed array

    static void rotate(int[][] arr, int r, int c){
        // int[][] mat = transpose(arr, r, c);
        transposeInplace(arr, r, c);
        for (int i = 0; i < c; i++) {
            //reverse each element
            matrix.reverseArray(arr[i]);
        }
        // return mat;
    }

    Transpose() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter values of rows and columns");
        int r = sc.nextInt();
        int c = sc.nextInt();
       
        int mat[][] = new int[r][c];

        System.out.println("Enter "+r*c+" elements: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original matrix: ");
        matrix.printArr(mat);

        // System.out.println("Transpose of matrix using extra array: ");
        // m.printArr(transpose(mat, r, c));

        // System.out.println("Transpose of matrix using swap: ");
        // transposeInplace(mat, r, c);
        // m.printArr(mat);

        System.out.println("Rotated 90: ");
        rotate(mat, r, c);
        matrix.printArr(mat);


    }


}

class PascalTri{

    int[][] pascal(int n){
        int[][] ans = new int[n][];

        for (int i = 0; i < n; i++) {
            //ith row has i + 1 columns
            /*
             * ans[0] = new int[1]
             * ans[1] = new int[2]
             */
            ans[i] = new int[i + 1];
            //1st and last element of every row is 1
            ans[i][0] = ans[i][i] = 1;

            for (int j = 1; j < i; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
            }
        }

        return ans;
    }
    
    PascalTri() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n");
        int n = sc.nextInt();
       
        int mat[][] = pascal(n);
        matrix.printArr(mat);
        
    }
}
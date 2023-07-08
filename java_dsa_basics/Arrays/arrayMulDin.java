//basics of multidimensional array

import java.util.Scanner;

public class arrayMulDin {
    static void printArr(int [][] arr){

        for (int i = 0; i < arr.length; i++) { //for rows
            for (int j = 0; j < arr[i].length; j++) { //for columns
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void matrixinput(int [][] arr, int r, int c){
        Scanner sc = new Scanner(System.in);
        

        System.out.println("Enter "+r*c+" numbers:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static void addMat(int mat1[][], int mat2[][]) {
        int res[][] = new int[mat1.length][mat1[0].length];

        if(mat1.length != mat2.length && mat1[0].length != mat2[0].length){
            System.out.println("invalid dimensions were entered:");
            return;
        }
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                res[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        System.out.println("Matrix sum: ");
        printArr(res);
    }

    static void mulMat(int mat1[][], int mat2[][]){
        if(mat1[0].length != mat2.length)//c1 = r2
        return;
        int mul[][] = new int[mat1.length][mat2[0].length]; //r1*c2

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                for (int j2 = 0; j2 < mat1[0].length; j2++) { // till c1 since it will add all the multiplied values
                    //mul[][j] = ith row of mat1 * jth col of mat2
                    mul[i][j] += mat1[i][j2] * mat2[j2][j];
                }
            }
        }
        System.out.println("Multiplication: ");
        printArr(mul);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and columns:");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int mat1[][] = new int[r][c];
        matrixinput(mat1, r, c);

        System.out.println("Enter number of rows and columns:");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] mat2 = new int[r1][c1];
        matrixinput(mat2, r1, c1);

        System.out.println("original array");
        printArr(mat1);

        System.out.println("matric2");
        printArr(mat2);
        // addMat(mat1, mat2);
        mulMat(mat1, mat2);
        


    }
}

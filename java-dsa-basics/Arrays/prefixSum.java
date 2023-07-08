import java.util.Scanner;

public class prefixSum {
    static void printArr(int [][] arr){

        for (int i = 0; i < arr.length; i++) { //for rows
            for (int j = 0; j < arr[i].length; j++) { //for columns
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void findPrefixSumMatrix(int arr[][]){
        int r = arr.length;
        int c = arr[0].length;

        //traverse horizontally to cal row-wise prefix sum
        for(int i = 0; i < r; i++){ //fixing rows
            for (int j = 1; j < c; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
    }

    static void findPrefixSumMatrixB(int arr[][]){
        //this method will return sum of rectangle bounded  (0,0) and (i,j)
        int r = arr.length;
        int c = arr[0].length;

        //traverse horizontally to cal row-wise prefix sum
        for(int i = 0; i < r; i++){ //fixing rows
            for (int j = 1; j < c; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }

        //traverse vertically to cal row-wise prefix sum
        for(int j = 0; j < c; j++){ //fixing columns
            for (int i = 1; i < r; i++) {
                arr[i][j] += arr[i - 1][j];
            }
        }
    }

    public static void main(String[] args) {
        PrefixSumQues p = new PrefixSumQues();
    }
}

class PrefixSumQues{
    //method 1 brute force approach
    static int findSum(int[][] matrix, int l1, int r1, int l2, int r2){
        int sum = 0;
        for (int i = l1; i <= l2; i++) {
            for (int j = r1; j <= r2; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
    //method 2 using prefix Sum array
    static int findSum2(int[][] matrix, int l1, int r1, int l2, int r2){
        int sum = 0;
        prefixSum.findPrefixSumMatrix(matrix);

        for (int i = l1; i <= l2; i++) {
            //r1 to r2 sum for row i
            if(r1 >= 1)
            sum += matrix[i][r2] - matrix[i][r1-1];
            else
            sum += matrix[i][r2];
            
        }

        return sum;
    }

    //method 3 prefix Sum over columns and rows both
    static int findSum3(int[][] matrix, int l1, int r1, int l2, int r2){
        int ans = 0, sum = 0, up = 0, left = 0, leftUp = 0;
        prefixSum.findPrefixSumMatrixB(matrix);

        sum = matrix[l2][r2];
        if(r1 >= 1)
            left = matrix[l2][r1-1];
        if(l1 >= 1)
            up = matrix[l1 - 1][r2];
        if(l1>=1 && r1>=1)
            leftUp = matrix[l1 - 1][r1 - 1];

        ans = sum - up - left + leftUp;

        System.out.println("Sum: "+sum);
        System.out.println("Left: "+left);
        System.out.println("Up: "+up);
        System.out.println("Leftup: "+leftUp);

        return ans;
    }


    PrefixSumQues(){
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

        System.out.println("Enter range of rectangle (l1,r1) and (l2,r2): ");
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();

        System.out.println("Original matrix: ");
        prefixSum.printArr(mat);

        System.out.println("Rectangle Sum: "+ findSum(mat, l1, r1, l2, r2));
        // System.out.println("Rectangle Sum: "+ findSum2(mat, l1, r1, l2, r2));
        System.out.println("Rectangle Sum: "+ findSum3(mat, l1, r1, l2, r2));

    }
}

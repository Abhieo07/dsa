import java.util.Scanner;

public class matrixSpiral {
    static void printArr(int [][] arr){

        for (int i = 0; i < arr.length; i++) { //for rows
            for (int j = 0; j < arr[i].length; j++) { //for columns
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // printSpiral p = new printSpiral();
        // generate g = new generate();
        // arrayTospiralMatrix s = new arrayTospiralMatrix();
        printSpiralAnti anti = new printSpiralAnti();

    }

}

class printSpiral{

    static void printSpiralOrder(int[][] mat, int r, int c){
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalEle = 0;

        while (totalEle < r * c) {
            // topRow -> leftCol to rightCol
            for(int j = leftCol; j <= rightCol && totalEle < r * c; j++){
                System.out.print(mat[topRow][j]+" ");
                totalEle++;
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for(int i = topRow; i <= bottomRow && totalEle < r * c; i++){
                System.out.print(mat[i][rightCol]+" ");
                totalEle++;
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for(int j = rightCol; j >= leftCol && totalEle < r * c ; j--){
                System.out.print(mat[bottomRow][j]+" ");
                totalEle++;
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for(int i = bottomRow; i >= topRow && totalEle < r * c; i--){
                System.out.print(mat[i][leftCol]+" ");
                totalEle++;
            }
            leftCol++;
        }
    }


    printSpiral(){
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
        matrixSpiral.printArr(mat);

        System.out.println("Spiral Order : ");
        printSpiralOrder(mat, r,c);
    }

}

class generate{

    static int[][] generateSpiral(int n){
        int matrix[][] = new int[n][n];
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
        int curr = 1;

        while(curr <= n * n){
            for(int j = leftCol; j <= rightCol && curr <= n * n; j++){
                matrix[topRow][j] = curr++;
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for(int i = topRow; i <= bottomRow && curr <= n * n; i++){
                matrix[i][rightCol] = curr++;
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for(int j = rightCol; j >= leftCol && curr <= n * n ; j--){
                matrix[bottomRow][j] = curr++;
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for(int i = bottomRow; i >= topRow && curr <= n * n; i--){
                matrix[i][leftCol] = curr++;
            }
            leftCol++;
        }

        return matrix;
    }

    generate() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter values of n to generate spiral matrix: ");
        int n = sc.nextInt();

        int[][] generated = generateSpiral(n);
        matrixSpiral.printArr(generated);
    }
}

class arrayTospiralMatrix{

    static void arraySpiral(int[] arr, int r, int c){
        if(r*c != arr.length){
            System.out.println("Invalid desire of "+r+" * "+c+" matrix");
            return; 
        }
        int[][] mat = new int[r][c];
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalEle = 0;

        while (totalEle < r * c) {
            // topRow -> leftCol to rightCol
            for(int j = leftCol; j <= rightCol && totalEle < r * c; j++){
                mat[topRow][j] = arr[totalEle++];
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for(int i = topRow; i <= bottomRow && totalEle < r * c; i++){
                mat[i][rightCol] = arr[totalEle++];
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for(int j = rightCol; j >= leftCol && totalEle < r * c ; j--){
                mat[bottomRow][j] = arr[totalEle++];
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for(int i = bottomRow; i >= topRow && totalEle < r * c; i--){
                mat[i][leftCol] = arr[totalEle++];
            }
            leftCol++;
        }

        System.out.println("Spiral Matrix: ");
        matrixSpiral.printArr(mat);
    }

    arrayTospiralMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array:");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter desire rows and columns of spiral matrix: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        arraySpiral(arr, r, c);
    }
}

class printSpiralAnti{

    static void printSpiralOrder(int[][] mat, int r, int c){
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int totalEle = 0;

        while (totalEle < r * c) {
            // topRow -> rightCol to leftCol
            for(int j = rightCol; j >= leftCol && totalEle < r * c; j--){
                System.out.print(mat[topRow][j]+" ");
                totalEle++;
            }
            topRow++;

            // leftCol -> topRow to bottomRow
            for(int i = topRow; i <= bottomRow && totalEle < r * c; i++){
                System.out.print(mat[i][leftCol]+" ");
                totalEle++;
            }
            leftCol++;

            // bottomRow -> leftCol to rightCol
            for(int j = leftCol; j <= rightCol  && totalEle < r * c ; j++){
                System.out.print(mat[bottomRow][j]+" ");
                totalEle++;
            }
            bottomRow--;

            // rightCol -> bottomRow to topRow
            for(int i = bottomRow; i >= topRow && totalEle < r * c; i--){
                System.out.print(mat[i][rightCol]+" ");
                totalEle++;
            }
            rightCol--;
            
        }
    }


    printSpiralAnti(){
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
        matrixSpiral.printArr(mat);

        System.out.println("Spiral Order Anticlockwise : ");
        printSpiralOrder(mat, r,c);
    }

}

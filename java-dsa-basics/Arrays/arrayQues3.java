import java.util.Scanner;

public class arrayQues3 {
    //swap two integer
    static void swap(int a, int b) {
        System.out.println("Original values before swap: ");
        System.out.println("a: "+a);
        System.out.println("b: "+b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("values after swap: ");
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }

    //swap using sum and difference method
    static void swapWithoutTemp(int a, int b) {
        System.out.println("Original values before swap: ");
        System.out.println("a: "+a);
        System.out.println("b: "+b);

        a = a + b; // Ac = Ao + Bo
        b = a - b; // Bc = Ac - Bo ---> Bc = (Ao + Bo) - Bo == Ao
        a = a - b; // Acc = Ac - Bc ----> Acc = (Ao + Bo) - Ao == Bo

        System.out.println("values after swap: ");
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }

    //reverse arrays of integer values
    static int[] reverseArray(int arr[]) {
        int ans[] = new int[arr.length];
        int j = 0;

        //traverse original array in reverse direction
        for (int i = arr.length - 1; i >= 0 ; i--) {
            ans[j++] = arr[i];
        }
        
        return ans;
    }

    static void reverseSameArray(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            //swap using temp
            // int temp = arr[i];
            // arr[i] = arr[j];
            // arr[j] = temp;

            //using sum diff method
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
    }

    //rotate the given array by k steps
    static int[] rotate(int arr[], int k) {
        k = k % arr.length;
        int ans[] = new int[arr.length];
        int j = 0;

        //fiterate from n-k to n
        for (int i = arr.length - k; i < arr.length; i++) {
            ans[j++] = arr[i];
        }
        //iterate from 0 to n - k
        for (int i = 0; i < arr.length - k; i++) {
            ans[j++] = arr[i];
        }

        return ans;
    }

    //rotate the given array by k steps without using extra spaces
    static void rotateImplicit(int arr[], int k) {
        k = k % arr.length; // reverse of k times will generate the rotated array
        
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k , arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    //reverse an array ranging i to j
    static void reverse(int arr[], int i, int j) {
        while(i < j) {
            //swap using temp
            // int temp = arr[i];
            // arr[i] = arr[j];
            // arr[j] = temp;

            //using sum diff method
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
    }

    static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter two values a and b");
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // swap(a, b);
        // swapWithoutTemp(a, b);

        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter "+n+" elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        
        // System.out.println("Reverse array: ");
        // int rev[] = reverseArray(arr);
        // printArr(rev);
        // reverseSameArray(arr);
        // printArr(arr);

        System.out.println("Enter value of k: ");
        int k = sc.nextInt();

        System.out.println("Orriginal array: ");
        printArr(arr);
        // int ans[] = rotate(arr, k);
        rotateImplicit(arr, k);
        System.out.println("After rotation:");
        printArr(arr);
    }
}

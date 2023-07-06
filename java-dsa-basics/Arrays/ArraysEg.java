import java.util.Arrays;
import java.util.Scanner;

public class ArraysEg {

    static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static void changeArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    static void changeVal(int a) {
        a = 100;
    }

    static int countVal(int arr[], int x) {
        int count = 0;
        for (int i : arr) {
            if(i == x)
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter "+n+" elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //count number of occurence in array
        System.out.println("Enter number to count: ");
        int a = sc.nextInt();
        System.out.println("Total occurrence of "+a+" "+countVal(arr, a));
        System.out.println("Original array: ");
        printArr(arr);


        // //trying to copy arr
        // int arr2[] = arr; //it can be done using arr2 = arr.clone();
        // System.out.println("Copied array: ");
        // printArr(arr2);

        // //changing some value of arr2
        // arr2[0] = 0;
        // arr2[1] = 0;

        // System.out.println("Original array after changing arr2: ");
        // printArr(arr);

        // System.out.println("Copied array after changing arr2: ");
        // printArr(arr2);
        
        //ARRAY REFERENCE IN JAVA
        // int arr[] = new int[3];
        // arr[0] = 12;
        // arr[1] = 56;
        // arr[2] = 13;
        
        // int a = 5;
        // System.out.println("value of a before changeVal: ");
        // System.out.println(a);
        // changeVal(a);
        // System.out.println("value of a after changeVal: ");
        // System.out.println(a);
        // System.out.println("array before calling changeArr ");
        // printArr(arr);
        // changeArr(arr);
        // System.out.println("array after calling changeArr ");
        // printArr(arr);

        // System.out.println("original array:");
        // printArr(arr);

        //deep copy
        // int arr2[] = arr.clone();
        // printArr(arr2);
        // int arr2[] = Arrays.copyOf(arr,arr.length); //we can provide the range of copy [   )
        // System.out.println("Copied array: ");
        // printArr(arr2);

        

        

        
    }

}

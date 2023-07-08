public class arrayEg {

    void singleArray() {
        int[] ages = new int[3];
        float weight[] = new float[3];
        String[] names = {"'Rahul'","'Aman'","'Aditya'"};

        ages[0] = 34;
        ages[1] = 12;
        ages[2] = 45;

        // System.out.println(ages.length);
        // System.out.println(names.length);
        // System.out.println(weight.length);

        for (int i = 0; i < 3; i++) {
            System.out.println(ages[i]);
        }

        for (int age : ages) {
            System.out.println(age);
        }
        int i = 0;
        while(i < 3) {
            System.out.println(names[i]);
            ++i;
        }

    }

    void multiArrays() {
        int arr_1[][] = new int[5][3];
        int[][] arr = {{56,12,42},{45,3,12}};
        int [][][] arr_3 = new int[5][3][2];
        arr_3[0][0][0] = 1;

        // System.out.println(arr[0][0]);
        // System.out.println(arr[0][1]);
        // System.out.println(arr[0][2]);

        // System.out.println(arr[1][0]);
        // System.out.println(arr[1][1]);
        // System.out.println(arr[1][2]);

        // System.out.println(arr[2][0]);
        // System.out.println(arr[2][1]);
        // System.out.println(arr[2][2]);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    int sumOfArray(int[] arr) {
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    int arrMax(int[] arr) {
        int max = arr[0];

        for (int i : arr) {
            if(max < i + 1)
            max = i;
        }

        return max;
    }

    int indexOf(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x)
            return i;
        }

        return -1;
    }

    

    public static void main(String[] args) {
       arrayEg obj = new arrayEg();
       //obj.multiArrays();
       //obj.singleArray();
       int[] arr = {1,8,2,3,4,6,5,8};
    //    System.out.println("Sum of array " +obj.sumOfArray(arr));

    //    System.out.println("Maximum of arr: " +obj.arrMax(arr));
        int ans = obj.indexOf(arr, 8);
        if(ans != -1)
        System.out.println("Found 8 at index " +ans);
        else
        System.out.println("Not found");
    }
}

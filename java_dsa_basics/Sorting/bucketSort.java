package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bucketSort {
    static void printArr(float[] arr){
        for (float i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    static void bucketSortAl(float[] arr){
        // buckets
        ArrayList<Float>[] buckets = new ArrayList[arr.length];
        // create empty buckets
        for (int i = 0; i < arr.length; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        // Add elements into our buckets
        for (int i = 0; i < arr.length; i++) {
            int bucketIdx = (int) arr[i] * arr.length;
            buckets[bucketIdx].add(arr[i]);
        }

        // sort each bucket individually
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);
        }

        // merge all buckets to get final sorted value
        int idx = 0;
        for (int i = 0; i < buckets.length; i++) {
            ArrayList<Float> currBucket = buckets[i];
            for (int j = 0; j < currBucket.size(); j++) {
                arr[idx++] = currBucket.get(j);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();
        float[] arr = new float[n];
        System.out.println("Enter elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextFloat();
        }
        bucketSortAl(arr);
        System.out.println("After sorting: ");
        printArr(arr);
        
    }
}

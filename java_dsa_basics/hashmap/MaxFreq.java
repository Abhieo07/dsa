package java_dsa_basics.hashmap;

import java.util.*;

public class MaxFreq {
    public static void main(String[] args) {
        Map<Integer,Integer> mp = new HashMap<>();
        int[] arr = {1,3,2,1,4,1,4,4,4,5,1,4,3,2};
        
        for (int i = 0; i < arr.length; i++) {
            if(mp.containsKey(arr[i])){
                mp.put(arr[i], mp.get(arr[i])+1);
            }
            mp.putIfAbsent(arr[i], 1);
        }
        int max = Integer.MIN_VALUE;
        int maxEle = -1;
        // for (var i : mp.entrySet()) {
        //     if(i.getValue() > max){
        //         max = i.getValue();
        //         maxEle = i.getKey();
        //     }
        // }

        for (var key : mp.keySet()) {
            if(max < mp.get(key)){
                max = mp.get(key);
                maxEle = key;
            }
        }
        System.out.printf("%d has max frequency and it ocuurs %d times", maxEle, max);
    }
}

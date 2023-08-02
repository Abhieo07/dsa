package cn;
// check parity and check sum

import java.util.HashMap;
import java.util.Scanner;

public class ErrorControl {
    
    public static void main(String[] args) {
        HashMap<Integer,Integer> frame = new HashMap<>(); //index,value
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length  of frame: ");
        int n = sc.nextInt();
        System.out.println("Enter frame");
        for (int i = 1; i <= n; i++) {
            frame.put(i, sc.nextInt());
        }
        System.out.println(parityCheck(frame));
    }


    private static String parityCheck(HashMap<Integer, Integer> frame) {
        // sender side
        int n = frame.size();
        int count = 0;
        int parity;
        for (Integer value : frame.values()) {
            if(value == 1) count++;
        }
        if(count % 2 == 0) parity = 0;
        else parity = 1;
        frame.put(n+1, parity);
        

        // receiver side
        count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("\nEnter Choice \n1: Without Error\n2:With Error\n");
        int choice = sc.nextInt();
        if(choice == 1){
            for (Integer value : frame.values()) {
                if(value == 1) count++;
            }
            
        } else if(choice == 2){
            int change = (int)Math.round(n*Math.random());
            int x = frame.get(change);
            if(x == 0) frame.put(change,1);
            else frame.put(change, 0);

            for (Integer value : frame.values()) {
                if(value == 1) count++;
            }
            
        }
        System.out.println(frame.values());
        if(count % 2 == 0) return "No Error";
        else return "Error";
    }
}

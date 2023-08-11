package cn;

import java.util.ArrayList;
import java.util.List;

public class hamming {
    static String[] senderSide(int n){
        // converting to its binary
        List<Integer> binary = toBinary(n);
        // calculating redundant bit
        int m = binary.size();
        int r = redundant(m,0);
        System.out.println("redundant "+r);
        // filling into dataframe
        String[] data = new String[m+r+1]; //1 base indexing
        String[] dataframe = filldata(data,binary,r);

        for (int i = 0; i < dataframe.length-1; i++) {
            System.out.print(dataframe[i]+" ");
        }
        System.out.println();
        // redundant family
        int[][] table = new int[data.length][r];
        createTable(table);
        // counting parity of each family R4,R3,R2,R1
        int parityR1 = parityCheck(table,r-1);
        int parityR2 = parityCheck(table,r-2);
        int parityR4 = parityCheck(table,r-3);
        int parityR8 = parityCheck(table,r-4);
        System.out.println("\nParity "+parityR1+","+parityR2+","+parityR4+","+parityR8);

        // replacing redundant by parity of redundant
        for (int i = 0; i < dataframe.length-1; i++) {
            if(dataframe[i].equals("R1")) dataframe[i] = ""+parityR1;
            if(dataframe[i].equals("R2")) dataframe[i] = ""+parityR2;
            if(dataframe[i].equals("R4")) dataframe[i] = ""+parityR4;
            if(dataframe[i].equals("R8")) dataframe[i] = ""+parityR8;
        }

        System.out.println("After adding values of redundant bit");
        for (int i = 0; i < dataframe.length-1; i++) {
            System.out.print(dataframe[i]+" ");
        }
        System.out.println();
        // send it to the receiver side

        return dataframe;
    }
    
    static List<Integer> convertToList(String[] str){
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if(str[i] == null) continue;
            arr.add(Integer.parseInt(str[i]));
        }
        return arr;
    }

    private static int parityCheck(int[][] table, int r) {
        int count=0;
        for (int i = 0; i < table.length; i++) {
            if(table[i][r] == 1)count++;
        }
        return count%2;
    }

    private static void createTable(int[][] table) {
        for (int i = 1; i < table.length; i++) {
            List<Integer> b = toBinary(i);
            for (int j = 0; j < table[i].length; j++) {
                if(b.size()>0) table[i][j] = b.remove(b.size()-1);
                else continue;
            }
            int j = 0;
            int k = table[i].length -1;
            while (j <= k) {
                int temp = table[i][j];
                table[i][j] = table[i][k];
                table[i][k] = temp;
                j++;
                k--;
            }
        }
    }

    private static String[] filldata(String[] data, List<Integer> binary, int r) {
        int t = 0, t1 = binary.size()-1;
        for (int i = 1; i < data.length; i++) {
            if(t < r && i == Math.pow(2, t)){
                data[data.length-1-i] = "R"+i;
                t++;
            }else{
                if(t1 >= 0){
                    data[data.length-1-i] = ""+binary.get(t1--);
                }
            }
        }
        return data;
    }

    private static int redundant(int m, int r) {
        if(Math.pow(2, r) >= m + r + 1) return r;
        return redundant(m, r+1);
    }

    private static List<Integer> toBinary(int n) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> binary = new ArrayList<>();
        while (n > 0) {
            temp.add(n%2);
            n /= 2;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            binary.add(temp.get(i));
        }
        return binary;
    }

    public static void main(String[] args) {
        System.out.println("Sending side: ");
        String[] senderSideMess =  senderSide(84);
        System.out.println();
        System.out.println("receiving side: ");
        System.out.println();
        receiverSide(senderSideMess);
    }

    private static void receiverSide(String[] senderSideMess) {
        List<Integer> received = convertToList(senderSideMess);
        int m = received.size();
        int r = redundant(m, 0);
        System.out.println("redundant: " +r);
        String[] data = new String[m+r+1]; //1 base indexing
        String[] dataframe = filldata(data,received,r);
        for (int i = 0; i < dataframe.length-1; i++) {
            System.out.print(dataframe[i]+" ");
        }
        int[][] table = new int[data.length][r];
        createTable(table);
        
        int parityR1 = parityCheck(table,r-1);
        int parityR2 = parityCheck(table,r-2);
        int parityR4 = parityCheck(table,r-3);
        int parityR8 = parityCheck(table,r-4);
        System.out.println("\nParity "+parityR1+","+parityR2+","+parityR4+","+parityR8);

        if(parityR1 == 1 || parityR2 == 1 || parityR4 == 1 || parityR8 == 1){
            System.out.println("Error");
            return;
        }
        else{
            System.out.println("No error");
        }
    }
}

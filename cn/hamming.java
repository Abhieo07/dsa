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
        int parityR1 = parityCheck2(table,dataframe,r-1);
        int parityR2 = parityCheck2(table,dataframe,r-2);
        int parityR4 = parityCheck2(table,dataframe,r-3);
        int parityR8 = parityCheck2(table,dataframe,r-4);
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

    private static int parityCheck2(int[][] table, String[] dataFrame, int r) {
        
        int [] msg = new int[dataFrame.length-1];
        for (int i = 0; i < msg.length; i++) {
            if(dataFrame[i] == null) continue;
            if(dataFrame[i].equals("0") || dataFrame[i].equals("1"))
                msg[i] = Integer.parseInt(dataFrame[i]);
            else msg[i] = -1;
        }
        System.out.println();

        List<Integer> fam = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if(table[i][r] == 1)
                fam.add(i);
        }
        int count=0;
        int x = 0;
        for (int i = 0; i < msg.length; i++) {
            if(x < fam.size() && msg[fam.get(x)] == 1) {
                x++;
                count++;
            }
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
        // without error
        System.out.println("Without error");
        receiverSide(senderSideMess);

        // with error
        int x = (int)((senderSideMess.length-1)*Math.random());
        System.out.println(senderSideMess.length-x-1);
        if(senderSideMess[x].equals("0")){
            senderSideMess[x] = "1";
        }
        else senderSideMess[x] = "0";
        System.out.println("With error : ");
        receiverSide(senderSideMess);
    }

    private static void receiverSide(String[] senderSideMess) {
        List<Integer> received = convertToList(senderSideMess);
        System.out.println("received: "+ received);
        
        List<Integer> redundantbits = new ArrayList<>();
        int t = 0;
        // getting redundand bit value
        for (int i = 1; i <= received.size(); i++) {
            if(i == Math.pow(2,t)){
                // System.out.println(i+"th value: "+ received.get(received.size()-i));
                redundantbits.add(received.get(received.size()-i));
                t++;
            }
        }
        System.out.println("Parity of received array : "+ redundantbits);
        int m = redundantbits.size();
        int[][] table2 = new int[received.size()+1][m];
        createTable(table2);
        // for (int i = 1; i < table.length; i++) {
        //     for (int j = 0; j < table[i].length; j++) {
        //         System.out.print(table[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // counting parity of each family R4,R3,R2,R1
        int parityR1 = parityCheck2(table2,senderSideMess,m-1);
        parityR1 = (parityR1 + redundantbits.get(0))%2;
        int parityR2 = parityCheck2(table2,senderSideMess,m-2);
        parityR2 = (parityR2 + redundantbits.get(1))%2;
        int parityR4 = parityCheck2(table2,senderSideMess,m-3);
        parityR4 = (parityR4 + redundantbits.get(2))%2;
        int parityR8 = parityCheck2(table2,senderSideMess,m-4);
        parityR8 = (parityR8 + redundantbits.get(3))%2;
        System.out.println("\nParity "+parityR1+","+parityR2+","+parityR4+","+parityR8);

        if(parityR1 == 1 ) System.out.println("Error at R1");
        else if(parityR2 == 1) System.out.println("Error at R2");
        else if(parityR4 == 1) System.out.println("Error at R4");
        else if(parityR8 == 1) System.out.println("Error at R8");
        else System.out.println("No error: ");
    }
}

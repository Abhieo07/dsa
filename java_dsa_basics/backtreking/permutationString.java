package backtreking;

import java.util.ArrayList;
import java.util.List;

public class permutationString {
    static void printPermutation(String str, String res, List<String> l){
        if(str.length() <= 0){
            l.add(res);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); //b
            String left = str.substring(0,i); //a
            String right = str.substring(i+1); //c
            String rem = left + right; //ac
            printPermutation(rem, res+ch,l);
        }
    }
    
    public static void main(String[] args) {
        String str = "abc";
        List<String> l = new ArrayList<>();
        printPermutation(str,"",l);
        System.out.println(l);
    }
}

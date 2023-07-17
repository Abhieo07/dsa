package java_dsa_basics.String;

import java.util.Scanner;

public class pallSubstr {
    static boolean isPallindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int noOfPall(String str){
        int totalPallindromicSubstr = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subString = str.substring(i, j);
                if(isPallindrome(subString)) 
                    totalPallindromicSubstr++;
            }
        }
        return totalPallindromicSubstr;
    }

    static String reverseWordInSentance(StringBuilder str){
        String ans = "";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch != ' '){
                sb.append(ch);
            } else {
                sb.reverse();
                ans += sb + " ";
                sb = new StringBuilder("");
            }
        }

        return ans + sb.reverse(); // the last word will be in sb since it didnt get another space after the last word
    }

    static String compressString(String str){
        String ans = "" + str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if(curr == prev){
                count++;
            }else {
                if(count > 1) ans += count;
                count = 1;
                ans += curr;
            }
        }
        if(count > 1) ans += count;//the char count is not added according the logic

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String str = "abcdcba";
        // boolean flag = isPallindrome(str);
        // if(flag)
        //     System.out.println("Pallindrome!");
        // else System.out.println("Not pallindrome!");
        System.out.println("===============================================================");
        System.out.println("Enter string to get number of pallindromic substring: ");
        String str = sc.next();
        System.out.println("Total pallindromic Substring: "+noOfPall(str));

        System.out.println("===============================================================");
        System.out.println("Enter sentance to get reverse of each word : ");
        StringBuilder str2 = new StringBuilder(sc.nextLine());
        String ans = reverseWordInSentance(str2);
        System.out.println("Sentance of reversed word: \n"+ ans);

        System.out.println("===============================================================");
        System.out.println("Enter string to compress: ");
        String s = sc.next();
        System.out.println("Compressed String: \n"+ compressString(s));
        System.out.println("===============================================================");
    }   
}

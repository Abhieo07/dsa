package java_dsa_basics.String;

import java.util.*;

public class basics {
    static void subStr(String str){
        for (int i = 0; i < str.length(); i++) {
            for (int k = i+1; k <= str.length(); k++) {
                System.out.print(str.substring(i,k)+" ");
            }
        }
        System.out.println();
    }

    static void changeCase(StringBuilder str){

        for (int i = 0; i < str.length(); i++) {
            // P = p + 32
            // check -> alphabet- small, cap
            boolean flag = true; //true -> capital
            if(str.charAt(i) == ' ') continue;
            int asci = (int)str.charAt(i);
            if(asci >= 97) flag = false; //small
            if(flag){//capital
                asci += 32;
                str.setCharAt(i, (char)asci);
            }else{
                asci -= 32;
                str.setCharAt(i, (char)asci);
            }
        }
    }

    static void changeCase2(){
        String str = "PhYsiCs WaLlaH";
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            // P = p + 32
            // check -> alphabet- small, cap
            boolean flag = true; //true -> capital
            if(str.charAt(i) == ' ') continue;
            int asci = (int)str.charAt(i);
            if(asci >= 97) flag = false; //small
            if(flag){//capital
                asci += 32;
                str = str.substring(0, i) + (char)asci + str.substring(i+1);
            }else{
                asci -= 32;
                str = str.substring(0, i) + (char)asci + str.substring(i+1);
            }
        }
        System.out.println(str);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // CHAR INT STR 
        // String str = "abc";
        // str += "xyz";
        // str += 'X';
        // str += 10;
        // str += 10 + 20; // abc1020
        // System.out.println(str);

        // SUBSTRING
        // String str = "abcdef";
        // System.out.println(str.substring(0, 3)); // [0,n-1]
        // System.out.println(str.substring(0));

        // System.out.println("Enter string to get substring");
        // String str = sc.next();
        // subStr(str);

        // STRING BUILDER

        // StringBuilder str = new StringBuilder(sc.nextLine()); // to get user input
        // StringBuilder str = new StringBuilder("hello");
        // System.out.println(str);
        // // hello --> mello
        // str.setCharAt(0, 'm');
        // System.out.println(str);
        // str.append(true); // can append any datatypes
        // System.out.println(str);
        // str.insert(2,'y');
        // System.out.println(str);
        // str.deleteCharAt(2);
        // System.out.println(str);
        // str.delete(0, 2); // [start, end-1]
        // System.out.println(str);
        // str.reverse();
        // System.out.println(str);

        StringBuilder str = new StringBuilder(sc.nextLine());
        System.out.println(str);
        changeCase(str);
        System.out.println(str);
       // changeCase2();
    }
}
package Recurssion;

import java.util.Scanner;

public class string {
    // remove all occurences of a from given string
    static String iremoveA(String str){
        String ans = " ";

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != 'a' && str.charAt(i) != 'A')
            ans += str.charAt(i);
        }
        return ans;
    }

    static String removeA(String str, int idx){ //O(n2)
        if(str.length() == idx)
            return  " ";

        String subStr = removeA(str, idx + 1);
        if(str.charAt(idx) != 'a' && str.charAt(idx) != 'A')
            return str.charAt(idx) + subStr; // this '+' cancatation takes O(n)

        return subStr;
    }

    static String removeA2(String str){ //O(n2)
        if(str.length() == 0)
            return  " ";

        String subAns = removeA2(str.substring(1));
        if(str.charAt(0) != 'a' && str.charAt(0) != 'A')
            return str.charAt(0) + subAns;

        return subAns;
    }

    static String reverse(String str){
        if(str.length() == 0) return "";

        String subAns = reverse(str.substring(1));
        return subAns + str.charAt(0);
    }

    static boolean pallindrome(String str, int l, int r){ //O(n)
        if(l >= r) return true;
        
        return (str.charAt(r) == str.charAt(l) && pallindrome(str,l+1,r-1));
    }

    static boolean pallindromeInt(int arr[],int l, int r){
        if(l >= r) return true;
        return (arr[l] == arr[r] && pallindromeInt(arr, l + 1, r - 1));
    }

    //iterative approach to find pallindrome of an integer
    static boolean pal(int a){
        int l = 0;
        int r = 0;
        int t = a;
        while(t>0){
            t /= 10;
            r++;
        }
        while(l != r){
            if((a % 10) == (a /(int) Math.pow(10,r-1))){
                l++;
                r--;
            }
            return false;
        }
        return true;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String s = sc.nextLine();
        System.out.println("Iterative approach: "+iremoveA(s));
        System.out.println("Recurssive approach: "+removeA(s,0));
        System.out.println("Recurssive approach without indexing: "+removeA2(s));
        System.out.println("Reverse of string: "+s+" is: "+reverse(s));
        String rev = reverse(s);
        if(rev.equals(s))
            System.out.printf("%s is pallindrome\n",s);
        else 
            System.out.printf("%s is not pallindrome\n",s);
        
        System.out.println("Is pallindrome: "+pallindrome(s,0,s.length()-1));
    }
}

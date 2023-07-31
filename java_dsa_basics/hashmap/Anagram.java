package java_dsa_basics.hashmap;

import java.util.*;

public class Anagram {

    static HashMap<Character, Integer> makeFreqMap(String s){
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!mp.containsKey(s.charAt(i))) mp.put(s.charAt(i), 1);
            else mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
        }
        return mp;
    }

    static boolean validAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        Map<Character, Integer> mp1 = makeFreqMap(s1);
        Map<Character, Integer> mp2 = makeFreqMap(s2);

        return mp1.equals(mp2);
        
        // APROACH 2
        
    }

    static boolean validAnagram2(String s, String t){
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> mp = makeFreqMap(s);
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if(!mp.containsKey(ch)) return false;
            int curFreq = mp.get(ch);
            mp.put(ch,curFreq-1);
            curFreq = mp.get(ch);
            if(curFreq == 0) mp.remove(ch);
        }
        if(!mp.isEmpty()) return false;
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 strings: ");
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println("Valid Anagram: "+validAnagram2(s1,s2));
    }
}

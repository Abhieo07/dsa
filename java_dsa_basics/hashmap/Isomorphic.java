package java_dsa_basics.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class Isomorphic {
    static boolean IsomorphicString(String s, String t){//O(n2) using hashset O(n)
        HashMap<Character, Character> mp = new HashMap<>();
        HashSet<Character> st = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(mp.containsKey(s.charAt(i))){
                if(t.charAt(i) != mp.get(s.charAt(i))) return false;
            }
            // else if(mp.containsValue(t.charAt(i))) return false; //O(n)
            else if(st.contains(t.charAt(i))) return false; //O(1)
            else {
                mp.put(s.charAt(i), t.charAt(i));
                st.add(t.charAt(i));
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        String s = "aab";
        String t = "xxy";
        System.out.println(IsomorphicString(s, t));
    }
}

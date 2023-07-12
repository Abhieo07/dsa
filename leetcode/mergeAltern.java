package leetcode;

public class mergeAltern {
    static String mergeAlternately(String word1, String word2) {
            String merged = "";
            int n;
            int l1 = word1.length();
            int l2 = word2.length();
            if(l1 > l2){
                n = l1;
            }else n = l2;
    
            for(int i = 0; i < n; i++){
                if(i == l1 && l2 > l1){
                    merged = merged.concat(word2.substring(i,n));
                    return merged;
                } else if(i == l2 && l1 > l2){
                    merged = merged.concat(word1.substring(i,n));
                    return merged;
                }else {
                    merged += word1.charAt(i);
                    merged += word2.charAt(i);
                }
                
            }
            return merged;
    }
    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";
        System.out.println(mergeAlternately(word1,word2));
    }
}

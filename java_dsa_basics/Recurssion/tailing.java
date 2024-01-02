public class Main
{
    public static int pow(int x, int n){
        // return n==0?1:x*pow(x, n-1);
        if(n==0) return 1;
        int p = pow(x, n/2);
        p *= p;
        if((n & 1) == 1) p = x*p;
        return p;
    }
    
    public static int tailinProb(int n){
        if(n==0 || n==1) return 1;
        int verti = tailinProb(n-1);
        int hori = tailinProb(n-2);
        
        return verti + hori;
    }
    
    public static void removeDupes(String str, boolean[] arr, StringBuilder ans, int idx){
        if(idx == str.length()) {
            System.out.print(ans);
            return;
        }
        char ch = str.charAt(idx);
        if(arr[ch - 'a'] == true){
            removeDupes(str,arr,ans,idx+1);
        }
        else{
            arr[ch - 'a'] = true;
            removeDupes(str,arr,ans.append(ch),idx+1);
        }
    }
    
	public static void main(String[] args) {
	    String str = "removedupicateforthis";
	    removeDupes(str,new boolean[26],new StringBuilder(""),0);
		System.out.println();
	}
}

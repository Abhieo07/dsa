package stack;
import java.util.Stack;

public class prefixToPostfix {
    static String toPostfix(String prefix){
        Stack<String> post = new Stack<>();
        // traver backward
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            int num = (int)ch - '0';
            if(num >=0 && num <= 9){
                post.push(""+num);
            } else {
                String val1 = post.pop();
                String val2 = post.pop();
                post.push(val1 + val2 + ch);
            }
        }

        return post.pop();
    }

    public static void main(String[] args) {
        String prefix = "-9/*+5346";
        System.out.println("Postfix of given prefix "+ prefix + " : "+ toPostfix(prefix));
    }
}

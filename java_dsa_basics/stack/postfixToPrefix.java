package stack;
import java.util.Stack;

public class postfixToPrefix {
    static String toPrefix(String postfix){
        Stack<String> prefix = new Stack<>();
        // traver backward
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            int num = (int)ch - '0';
            if(num >=0 && num <= 9){
                prefix.push(""+num);
            } else {
                String val2 = prefix.pop();
                String val1 = prefix.pop();
                prefix.push("" + ch + val1 + val2);
            }
        }

        return prefix.pop();
    }

    public static void main(String[] args) {
        String postfix = "953+4*6/-";
        System.out.println("Prefix of given postfix "+ postfix + " : "+ toPrefix(postfix));
    }
}

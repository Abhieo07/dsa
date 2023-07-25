package stack;
import java.util.Stack;

public class postfixToInfix {
    static String toInfix(String postfix){
        Stack<String> infix = new Stack<>();
        // traver backward
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            int num = (int)ch - '0';
            if(num >=0 && num <= 9){
                infix.push(""+num);
            } else {
                String val2 = infix.pop();
                String val1 = infix.pop();
                infix.push("("+val1 + ch + val2+")");
            }
        }

        return infix.pop();
    }

    public static void main(String[] args) {
        String postfix = "953+4*6/-";
        System.out.println("Infix of given postfix "+ postfix + " : "+ toInfix(postfix));
    }
}

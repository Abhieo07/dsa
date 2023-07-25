package stack;
import java.util.Stack;

public class prefixToInfix {
    static String toInfix(String prefix){
        Stack<String> infix = new Stack<>();
        // traver backward
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            int num = (int)ch - '0';
            if(num >=0 && num <= 9){
                infix.push(""+num);
            } else {
                String val1 = infix.pop();
                String val2 = infix.pop();
                infix.push("("+val1 + ch + val2+")");
            }
        }

        return infix.pop();
    }

    public static void main(String[] args) {
        String prefix = "-9/*+5346";
        System.out.println("Infix of given prefix "+ prefix + " : "+ toInfix(prefix));
    }
}

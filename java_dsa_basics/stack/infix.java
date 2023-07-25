package stack;
import java.util.Stack;

public class infix {
    static int infixExp(String str){
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            
            char ch = str.charAt(i);
            int ascii = (int)ch;
            int temp = ascii - 48;
            if(temp <= 9 && temp > 0){
                val.push(temp);
            }else {
                if(op.size() == 0 || ch == '(' || op.peek() == '(') op.push(ch);
                else if(ch == ')'){
                    while (op.peek() != '(') {
                        int val2 = val.pop();
                        int val1 = val.pop();
                        char op1 = op.pop();
                        if(op1 == '-') val.push(val1 - val2);
                        if(op1 == '+') val.push(val1 + val2);
                        if(op1 == '*') val.push(val1 * val2);
                        if(op1 == '/') val.push(val1 / val2);
                    }
                    op.pop(); // '()' hata diya
                }
                else{ // op.size() > 0
                    if(ch == '+' || ch == '-'){ //priority setup
                        int val2 = val.pop();
                        int val1 = val.pop();
                        char op1 = op.pop();
                        if(op1 == '-') val.push(val1 - val2);
                        if(op1 == '+') val.push(val1 + val2);
                        if(op1 == '*') val.push(val1 * val2);
                        if(op1 == '/') val.push(val1 / val2);
                        op.push(ch);
                    }
                    if(ch == '*' || ch == '/'){
                        if(op.peek() == '*' || op.peek() == '/'){
                            int val2 = val.pop();
                            int val1 = val.pop();
                            char op1 = op.pop();
                            if(op1 == '*') val.push(val1 * val2);
                            if(op1 == '/') val.push(val1 / val2);
                            op.push(ch);
                        } else op.push(ch);
                    }
                }
            }
        }
        while (val.size() > 1) {
            int val2 = val.pop();
            int val1 = val.pop();
            char op1 = op.pop();
            if(op1 == '-') val.push(val1 - val2);
            if(op1 == '+') val.push(val1 + val2);
            if(op1 == '*') val.push(val1 * val2);
            if(op1 == '/') val.push(val1 / val2);
        }

        return val.peek();
    }
    
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        System.out.println("Infix Expression ans: "+infixExp(str));
    }
}

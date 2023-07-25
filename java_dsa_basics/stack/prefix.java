package stack;
import java.util.Stack;

public class prefix {

    static int prefixEvaluation(String postfix){
        Stack<Integer> val = new Stack<>();
        for (int i = postfix.length() - 1; i >= 0; i--) {
            char ch = postfix.charAt(i);
            int num = (int)ch - '0';
            if(num >= 0 && num <= 9){ 
                val.push(num);
            }else{
                int val1 = val.pop();
                int val2 = val.pop();
                if(ch == '-') val.push(val1 - val2);
                if(ch == '+') val.push(val1 + val2);
                if(ch == '*') val.push(val1 * val2);
                if(ch == '/') val.push(val1 / val2);
            }
        }
        return val.pop();

    }

    static String prefixExp(String str){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int num = (int)ch - '0';
            if(num <= 9 && num > 0) {
                String s = "" + ch;
                val.push(s);
            }
            else if(op.size() == 0 || ch == '(' || op.peek() == '(') op.push(ch);
            else if(ch == ')'){
                while (op.peek() != '(') {
                    String s2 = val.pop();
                    String s1 = val.pop();
                    char op1 = op.pop();
                    String t = op1 + s1 + s2;
                    val.push(t);
                }
                op.pop();
            }
            else{
                if(ch == '+' || ch == '-'){ //priority setup
                    String s2 = val.pop();
                    String s1 = val.pop();
                    char op1 = op.pop();
                    String t = op1 + s1 + s2;
                    val.push(t);
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek() == '/'){
                        String s2 = val.pop();
                        String s1 = val.pop();
                        char op1 = op.pop();
                        String t = op1 + s1 + s2;
                        val.push(t);
                        op.push(ch);
                    } else op.push(ch);
                }
            }
        }
        while (val.size() > 1) {
            String s2 = val.pop();
            String s1 = val.pop();
            char op1 = op.pop();
            String t = op1 + s1 + s2;
            val.push(t);
        }

        return val.pop();
    }

    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        String preFix = prefixExp(str);
        System.out.println("Prefix Expression of " + str + ": "+ preFix);
        System.out.println("Evaluation of Prefix Expression " + preFix + ": "+prefixEvaluation(preFix));
    }
}

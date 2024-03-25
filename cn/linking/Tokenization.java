import java.util.HashSet;

public class Tokenization{
    public static void main(String[] args) {
        System.out.println("Testing java......");
    }
}
class Token{
    String type;
    String value;

    HashSet<Character> delimiter = new HashSet<>();
    HashSet<String> keyword = new HashSet<>();
    public void addDelimeter(char deli){
        delimiter.add(deli);
    }

    public HashSet<Character> getDelimeter(){
        return delimiter;
    }

    Token(String input){
        int i=0;
        char ch = input.charAt(i);
        StringBuilder literal = new StringBuilder("");
        while (!delimiter.contains(ch)) {
            literal.append(ch);
            i++;
        }
        this.type = getType(literal.toString());
    }
    public int state0(char ch){
        if (Character.isWhitespace(ch)) {
            return 0; // Stay in state 0
        } else if (Character.isLetter(ch)) {
            return 1; // Transition to state 1
        } else {
            return -1; // Error
        }
    }
    
    public int state1(char ch){
        // Character or digit
        if (Character.isLetterOrDigit(ch)) {
            if (delimiter.contains(ch)) {
                // Retract by 1 character
                // i--;
                return 2; // Return (index, pointer)
            }
            return 1; // Stay in state 1
        } else {
            return -1; // Error
        }
    }
    
    public boolean isIdentifier(String input) {
        int length = input.length();
        int i = 0;
        while(i < length) {
            int state = state0(input.charAt(i));
            if(state == -1){
                return false;
            }else{
                if(state == 0){
                    state=state0(input.charAt(i));
                }
                else{
                    state=state1(input.charAt(i));
                    if(state == 2) return true;
                }
                i++;
            }
        }
        
        return true; // Error if the loop completes without reaching a valid end state
    }
    
    public String getType(String literal){
        String type = literal;
        if(keyword.contains(literal)) return "Keyword";

        // desigining dfa for identifier C(C+D)*
        // state 0 cleaning white spaces
        // if ch in character go to state 1 else error
        // if ch in character || ch in number stay in state 1 
            // else if ch in delimeter retract, return else error
        if(isIdentifier(literal)) return "Identifier";

        return type;
    }
}

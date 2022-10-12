import java.util.ArrayList;

import stacker.rpn.lexer.Token;
import stacker.rpn.lexer.TokenType;
import stacker.rpn.lexer.Regex;


public class Scanning {
    private static TokenType operation (String operator) {
        if (Regex.isPlus("+")) return TokenType.PLUS;
        else if (Regex.isMinus("-")) return TokenType.MINUS;
        else if (Regex.isStar("*")) return TokenType.STAR;
        else return TokenType.SLASH;
    }

    public static ArrayList<Token> scan(String exp) throws Exception {
        String[] components = exp.split(" ");
        ArrayList<Token> l = new ArrayList<Token>();
        for (String component : components) {
            if (Regex.isNum(component)) {
                Token t = new Token(TokenType.NUM, component);
                l.add(t);
            } else if (Regex.isOP(component)) {
                Token t = new Token(operation(component), component);
                l.add(t);
            } else {
                throw new Exception("Error: Unexpected Token: " + component);
            }
        }  
        return l;  
    } 
}

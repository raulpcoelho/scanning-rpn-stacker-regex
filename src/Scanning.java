import java.util.ArrayList;
import java.util.Scanner;

import stacker.rpn.lexer.Token;
import stacker.rpn.lexer.TokenType;


public class Scanning {
    private static boolean isInteger(String str) {
        Scanner sc = new Scanner(str.trim());
        if(!sc.hasNextInt(10)) return false;
        sc.nextInt(10);
        return !sc.hasNext();
    }

    private static TokenType operation (String operator) {
        if (operator.equals("+")) return TokenType.PLUS;
        else if (operator.equals("-")) return TokenType.MINUS;
        else if (operator.equals("*")) return TokenType.STAR;
        else return TokenType.SLASH;
    }

    public static ArrayList<Token> scan(String exp) throws Exception {
        String[] components = exp.split(" ");
        ArrayList<Token> l = new ArrayList<Token>();
        for (String component : components) {
            if (isInteger(component)) {
                Token t = new Token(TokenType.NUM, component);
                l.add(t);
            } else if ("+-/*".indexOf(component) == -1) {
                throw new Exception("Error: Unexpected Token: " + component);
            } else {
                Token t = new Token(operation(component), component);
                l.add(t);
            }
        }  
        return l;  
    } 
}

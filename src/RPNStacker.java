import java.util.ArrayList;
import java.util.Stack;
import stacker.rpn.lexer.Token;
import stacker.rpn.lexer.TokenType;


public class RPNStacker {

    private static int operation (Token t, int op1, int op2) {
        if (t.type == TokenType.PLUS) return op1 + op2;
        else if (t.type == TokenType.MINUS) return op1 - op2;
        else if (t.type == TokenType.STAR) return op1 * op2;
        else return op1 / op2;
    }

    public static int evaluate(ArrayList<Token> tokens){
        
        Stack<String> stack = new Stack<String>();

        for (Token token : tokens) {
            if (token.type == TokenType.NUM) {
                stack.push(token.lexeme);
            } else {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operation(token, op1, op2)));
            }
        }
        int result = Integer.parseInt(stack.pop());
        return result;
    } 
}

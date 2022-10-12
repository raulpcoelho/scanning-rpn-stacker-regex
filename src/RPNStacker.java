import java.util.ArrayList;
import java.util.Stack;
import stacker.rpn.lexer.Token;


public class RPNStacker {
    private static boolean isInteger(String str) {
        return str.matches("-?\\d+");
    }

    private static int operation (String operator, int op1, int op2) {
        if (operator.equals("+")) return op1 + op2;
        else if (operator.equals("-")) return op1 - op2;
        else if (operator.equals("*")) return op1 * op2;
        else return op1 / op2;
    }

    public static int evaluate(ArrayList<Token> tokens){
        
        Stack<String> stack = new Stack<String>();

        for (Token token : tokens) {
            if (isInteger(token.lexeme)) {
                stack.push(token.lexeme);
            } else {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operation(token.lexeme, op1, op2)));
            }
        }
        int result = Integer.parseInt(stack.pop());
        return result;
    } 
}

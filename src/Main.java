import java.util.Scanner;
import stacker.rpn.lexer.Token;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        StringBuilder exp = new StringBuilder();
        
        while (in.hasNextLine()) {
            line = in.nextLine();
            exp.append(line);
            exp.append(" ");
        }

        try {
            //Scanning:
            List<Token> tokens = Scanning.scan(exp.toString());
            for (Token token : tokens) {
                System.out.println(token);
            }
            //RPN evaluation:
            int result = RPNStacker.evaluate(tokens);
            System.out.println("Resultado: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        in.close();
    }
}

import token.Token;
import token.Tokenizer;
import visitor.CalcVisitor;
import visitor.ParserVisitor;
import visitor.PrintVisitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(System.in))) {
            String input;
            Tokenizer tokenizer = new Tokenizer();
            PrintVisitor printVisitor = new PrintVisitor(System.out);
            CalcVisitor calcVisitor = new CalcVisitor();

            System.out.println("Enter expression or 'exit' to exit");

            while (!Objects.equals(input = reader.readLine(), "exit")) {
                ParserVisitor parserVisitor = new ParserVisitor();

                List<Token> tokens = tokenizer.parse(input);
                printVisitor.print(tokens);

                List<Token> reversePolishNotation = parserVisitor.parse(tokens);
                printVisitor.print(reversePolishNotation);

                System.out.println(calcVisitor.calculate(reversePolishNotation));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}

package visitor;

import token.Brace;
import token.NumberToken;
import token.Token;
import token.operation.Operation;

import java.io.PrintStream;
import java.util.List;

public class PrintVisitor implements TokenVisitor {
    private final PrintStream out;

    public PrintVisitor(final PrintStream out) {
        this.out = out;
    }


    public void print(List<Token> tokens) {
        tokens.forEach(token -> token.accept(this));
        out.println();
    }

    @Override
    public void visit(NumberToken token) {
        print(token);
    }

    @Override
    public void visit(Brace token) {
        print(token);
    }

    @Override
    public void visit(Operation token) {
        print(token);
    }

    private void print(Token token) {
        out.append(token.toString()).append(" ");
    }
}

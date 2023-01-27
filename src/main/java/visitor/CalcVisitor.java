package visitor;

import token.Brace;
import token.NumberToken;
import token.Token;
import token.operation.Operation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CalcVisitor implements TokenVisitor {
    private final Deque<Integer> stack = new ArrayDeque<>();

    public int calculate(List<Token> tokens) {
        if (tokens.isEmpty()) {
            return 0;
        }

        tokens.forEach(token -> token.accept(this));

        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid tokens sequence");
        }

        return stack.pollLast();
    }

    @Override
    public void visit(NumberToken token) {
        stack.add(token.getValue());
    }

    @Override
    public void visit(Brace token) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void visit(Operation token) {
        if (stack.size() < 2) {
            throw new IllegalStateException();
        }
        int b = stack.pollLast();
        int a = stack.pollLast();
        stack.add(token.evaluate(a, b));
    }

}

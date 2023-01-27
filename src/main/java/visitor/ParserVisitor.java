package visitor;

import token.Brace;
import token.NumberToken;
import token.Token;
import token.TokenType;
import token.operation.Operation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ParserVisitor implements TokenVisitor {
    private List<Token> reversePolishNotation;
    private Deque<Token> stack;

    public List<Token> parse(List<Token> tokens) {
        reversePolishNotation = new ArrayList<>();
        stack = new ArrayDeque<>();

        tokens.forEach(token -> token.accept(this));

        while (!stack.isEmpty()) {
            reversePolishNotation.add(stack.pollLast());
        }

        return reversePolishNotation;
    }

    @Override
    public void visit(NumberToken token) {
        reversePolishNotation.add(token);
    }

    @Override
    public void visit(Brace token) {
        if (token.getTokenType().equals(TokenType.LEFT_BRACE)) {
            stack.add(token);
        } else {
            if (stack.isEmpty()) {
                throw new IllegalStateException();
            }
            Token nextToken = stack.pollLast();
            while (!stack.isEmpty()) {
                assert nextToken != null;
                if (nextToken.getTokenType().equals(TokenType.LEFT_BRACE)) break;
                reversePolishNotation.add(nextToken);
                nextToken = stack.pollLast();
            }
        }
    }

    @Override
    public void visit(Operation token) {
        if (!stack.isEmpty()) {
            Token nextToken = stack.peekLast();
            while (!stack.isEmpty() && token.getTokenType().priority <= nextToken.getTokenType().priority) {
                reversePolishNotation.add(stack.pollLast());
                nextToken = stack.peekLast();
            }
        }
        stack.add(token);
    }

}

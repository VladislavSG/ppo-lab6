package token.operation;

import token.TokenType;

public class Divide extends Operation {
    public Divide() {
        super(TokenType.DIV);
    }

    @Override
    public int evaluate(int left, int right) {
        return left / right;
    }
}

package token.operation;

import token.TokenType;

public class Minus extends Operation {
    public Minus() {
        super(TokenType.MINUS);
    }

    @Override
    public int evaluate(int left, int right) {
        return left - right;
    }
}

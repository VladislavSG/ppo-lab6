package token.operation;

import token.TokenType;

public class Plus extends Operation {
    public Plus() {
        super(TokenType.PLUS);
    }

    @Override
    public int evaluate(int left, int right) {
        return left + right;
    }
}

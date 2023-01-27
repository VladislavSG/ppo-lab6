package token.operation;

import token.TokenType;

public class Multiply extends Operation {
    public Multiply() {
        super(TokenType.MUL);
    }

    @Override
    public int evaluate(int left, int right) {
        return left * right;
    }
}

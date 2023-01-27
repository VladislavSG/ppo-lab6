package token.operation;

import token.Token;
import token.TokenType;
import visitor.TokenVisitor;

public abstract class Operation implements Token {
    private final TokenType operationType;

    public Operation(TokenType operationType) {
        this.operationType = operationType;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getTokenType() {
        return operationType;
    }

    public int evaluate(int a, int b) {
        throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Operation otherOperation)) {
            return false;
        }
        return operationType == otherOperation.operationType;
    }

    @Override
    public int hashCode() {
        return operationType.hashCode();
    }

    @Override
    public String toString() {
        return operationType.toString();
    }

}

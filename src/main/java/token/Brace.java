package token;

import visitor.TokenVisitor;

import java.util.Objects;

public class Brace implements Token {
    private final TokenType braceType;

    public Brace(boolean isLeft) {
        this.braceType = isLeft ? TokenType.LEFT_BRACE : TokenType.RIGHT_BRACE;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public TokenType getTokenType() {
        return braceType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Brace)) return false;
        Brace brace = (Brace) other;
        return Objects.equals(braceType, brace.braceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(braceType);
    }

    @Override
    public String toString() {
        return braceType.toString();
    }

}

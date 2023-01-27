package token;

public enum TokenType {
    LEFT_BRACE(0),
    RIGHT_BRACE(0),
    PLUS(1),
    MINUS(1),
    MUL(2),
    DIV(2),
    NUMBER(3);

    public final int priority;

    TokenType(int priority) {
        this.priority = priority;
    }
}

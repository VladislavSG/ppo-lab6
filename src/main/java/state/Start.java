package state;

import token.Brace;
import token.Token;
import token.Tokenizer;
import token.operation.Divide;
import token.operation.Minus;
import token.operation.Multiply;
import token.operation.Plus;

public class Start implements State {
    @Override
    public Token createToken(Tokenizer tokenizer) {
        char c = tokenizer.getCurrentCharacter();
        tokenizer.nextCharacter();
        return switch (c) {
            case '(' -> new Brace(true);
            case ')' -> new Brace(false);
            case '+' -> new Plus();
            case '-' -> new Minus();
            case '*' -> new Multiply();
            case '/' -> new Divide();
            default -> null;
        };
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        if (tokenizer.isEndOfInput()) {
            tokenizer.setState(new End());
        } else if (tokenizer.isNumber()) {
            tokenizer.setState(new Number());
        } else if (tokenizer.isOperationOrBrace()) {
            tokenizer.setState(new Start());
        } else {
            tokenizer.setState(new Error("Unexpected character : " + tokenizer.getCurrentCharacter()));
        }
    }

}

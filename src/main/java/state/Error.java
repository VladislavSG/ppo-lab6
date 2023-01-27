package state;

import token.Token;
import token.Tokenizer;

public class Error implements State {
    private final String message;

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public Token createToken(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextState(Tokenizer tokenizer) {
        throw new UnsupportedOperationException();
    }
}

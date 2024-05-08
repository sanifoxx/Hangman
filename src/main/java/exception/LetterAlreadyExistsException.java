package exception;

public class LetterAlreadyExistsException extends RuntimeException {

    public LetterAlreadyExistsException(String message) {
        super(message, null, true, false);
    }
}

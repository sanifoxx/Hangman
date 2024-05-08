package exception;

public class IncorrectLetterSequenceException extends RuntimeException {

    public IncorrectLetterSequenceException(String message) {
        super(message, null, true, false);
    }
}

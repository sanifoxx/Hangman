package exception;

public class UnknownCommandException extends RuntimeException {

    public UnknownCommandException(String message) {
        super(message, null, true, false);
    }
}

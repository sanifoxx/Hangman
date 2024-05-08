package exception;

import model.HangmanData;

public class ExceptionHandler {

    private static ExceptionHandler INSTANCE;

    private final HangmanData hangmanData;

    private ExceptionHandler() {
        this.hangmanData = HangmanData.getInstance();
    }

    public static ExceptionHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ExceptionHandler();
        }
        return INSTANCE;
    }

    public void handle(RuntimeException exception) {
        try {
            throw exception;

        } catch (
                UnknownCommandException
                | LetterAlreadyExistsException
                | IncorrectLetterSequenceException e
        ) {
            standardHandle(e);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    private void standardHandle(RuntimeException exception) {
        hangmanData.setException(exception);
    }
}

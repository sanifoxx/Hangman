package view;

import common.Constants;
import model.GameStatus;
import model.HangmanData;

import java.util.stream.Collectors;

public class HangmanView {

    private static HangmanView INSTANCE;

    private final HangmanData hangmanData;

    private final String inputPattern;

    private HangmanView() {
        this.hangmanData = HangmanData.getInstance();
        this.inputPattern = Constants.STANDARD_INPUT_PATTERN;
    }

    public static HangmanView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HangmanView();
        }
        return INSTANCE;
    }

    public void update() {
        System.out.print(
                buildFrame(
                        buildPicArea(),
                        buildWordArea(),
                        buildStatisticsArea(),
                        buildMessageArea(),
                        buildErrorArea(),
                        buildMenuArea(),
                        inputPattern
                )
        );
    }

    private String buildFrame(String picArea, String wordArea, String statisticArea, String messageArea,
                              String errorArea, String menuArea, String inputPattern) {
        return String.format(
                Constants.FRAME_FORMAT,
                picArea,
                wordArea,
                statisticArea,
                messageArea,
                errorArea,
                menuArea,
                inputPattern
        );
    }

    public String buildPicArea() {
        String result = Constants.EMPTY_LINE;
        if (GameStatus.MENU.equals(hangmanData.getGameStatus())) {
            result = Constants.HANGMAN_LOGO;
        }
        if (GameStatus.IN_GAME.equals(hangmanData.getGameStatus())) {
            result = Constants.HANGMAN_PIC.get(hangmanData.getMistakesCount());
        }
        if (GameStatus.WIN.equals(hangmanData.getGameStatus())) {
            result = Constants.YOU_WIN_PIC;
        }
        if (GameStatus.GAME_OVER.equals(hangmanData.getGameStatus())) {
            result = Constants.HANGMAN_PIC.get(hangmanData.getMistakesCount());
        }
        return result;
    }

    private String buildWordArea() {
        String result = Constants.EMPTY_LINE;
        if (GameStatus.MENU.equals(hangmanData.getGameStatus())) {
            return result;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : hangmanData.getWord().toCharArray()) {
            stringBuilder.append(
                    hangmanData.getOpenLetters().contains(letter)
                            ? letter
                            : Constants.UNKNOWN_LETTER_ELEMENT
            );
        }
        result = stringBuilder.append(Constants.EMPTY_LINE).toString();
        return result;
    }

    private String buildStatisticsArea() {
        String result = Constants.EMPTY_LINE;
        if (GameStatus.MENU.equals(hangmanData.getGameStatus())) {
            return Constants.EMPTY_LINE;
        }
        if (GameStatus.IN_GAME.equals(hangmanData.getGameStatus())) {
            result = String.format(
                    Constants.MISTAKES_AREA_FORMAT,
                    hangmanData.getMistakesCount(),
                    hangmanData.getWrongLetters()
                            .stream()
                            .map(Object::toString)
                            .sorted()
                            .collect(Collectors.joining(Constants.MISTAKES_DELIMITER))
            );
        }
        if (GameStatus.WIN.equals(hangmanData.getGameStatus())
                || GameStatus.GAME_OVER.equals(hangmanData.getGameStatus())) {
            result = String.format(
                    Constants.END_GAME_STATISTICS_FORMAT,
                    hangmanData.getAttemptsCount(),
                    hangmanData.getMistakesCount()
            );
        }
        return result;
    }

    private String buildMessageArea() {
        String result = Constants.EMPTY_LINE;
        if (GameStatus.MENU.equals(hangmanData.getGameStatus())) {
            result = Constants.WELCOME_MESSAGE;
        }
        if (GameStatus.IN_GAME.equals(hangmanData.getGameStatus())) {
            result = Constants.EMPTY_LINE;
        }
        if (GameStatus.WIN.equals(hangmanData.getGameStatus())
                || GameStatus.GAME_OVER.equals(hangmanData.getGameStatus())) {
            result = Constants.RELOAD_MESSAGE;
        }
        return result;
    }

    private String buildErrorArea() {
        String result = Constants.EMPTY_LINE;
        if (hangmanData.getException() != null) {
            result = hangmanData.getException().getMessage();
            hangmanData.setException(null);
        }
        return result;
    }

    private String buildMenuArea() {
        String result = Constants.EMPTY_LINE;
        if (GameStatus.MENU.equals(hangmanData.getGameStatus())) {
            result = Constants.MENU_YES_OR_NO;
        }
        if (GameStatus.IN_GAME.equals(hangmanData.getGameStatus())) {
            result = Constants.MENU_EXIT_TO_MENU;
        }
        if (GameStatus.WIN.equals(hangmanData.getGameStatus())
                || GameStatus.GAME_OVER.equals(hangmanData.getGameStatus())) {
            result = Constants.MENU_YES_OR_NO;
        }
        return result;
    }
}

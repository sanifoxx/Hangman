package controller;

import common.Constants;
import exception.IncorrectLetterSequenceException;
import exception.LetterAlreadyExistsException;
import exception.UnknownCommandException;
import model.GameStatus;
import model.HangmanData;
import repository.WordRepository;
import repository.WordRepositoryImpl;
import view.HangmanView;

import java.util.HashSet;
import java.util.stream.Collectors;

public class HangmanController {

    private static HangmanController INSTANCE;

    private final HangmanData hangmanData;

    private final HangmanView hangmanView;

    private final WordRepository wordRepository;

    private HangmanController() {
        this.hangmanData = HangmanData.getInstance();
        this.hangmanView = HangmanView.getInstance();
        this.wordRepository = WordRepositoryImpl.getInstance();
        this.hangmanData.setGameStatus(GameStatus.MENU);
    }

    public static HangmanController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HangmanController();
        }
        return INSTANCE;
    }

    public void updateView() {
        hangmanView.update();
    }

    public void initGame() {
        String word = wordRepository.getRandomWord();
        hangmanData.setGameStatus(GameStatus.IN_GAME);
        hangmanData.setWord(word);
        hangmanData.setAttemptsCount(0);
        hangmanData.setMistakesCount(0);
        hangmanData.setOpenLetters(new HashSet<>());
        hangmanData.setWrongLetters(new HashSet<>());
        hangmanData.setHiddenLetters(
                word.chars()
                        .mapToObj(elem -> (char) elem)
                        .collect(Collectors.toSet())
        );
    }

    public void handleInput(String input) {
        if (GameStatus.MENU.equals(hangmanData.getGameStatus())) {
            menuHandler(input);
            return;
        }
        if (GameStatus.IN_GAME.equals(hangmanData.getGameStatus())) {
            inGameHandler(input);
            return;
        }
        if (GameStatus.WIN.equals(hangmanData.getGameStatus())
                || GameStatus.GAME_OVER.equals(hangmanData.getGameStatus())) {
            endGameHandler(input);
        }
    }

    private void menuHandler(String action) {
        if (!Constants.VALID_MENU_COMMANDS.contains(action)) {
            throw new UnknownCommandException(
                    Constants.UNKNOWN_COMMAND_MESSAGE
            );
        }
        if (Constants.REFUSE_COMMAND.equals(action)) {
            hangmanData.setGameStatus(GameStatus.EXIT);
        }
        if (Constants.ACCEPT_COMMAND.equals(action)) {
            initGame();
        }
    }

    private void endGameHandler(String action) {
        if (!Constants.VALID_MENU_COMMANDS.contains(action)) {
            throw new UnknownCommandException(
                    Constants.UNKNOWN_COMMAND_MESSAGE
            );
        }
        if (Constants.REFUSE_COMMAND.equals(action)) {
            hangmanData.setGameStatus(GameStatus.EXIT);
        }
        if (Constants.ACCEPT_COMMAND.equals(action)) {
            initGame();
        }
    }

    private void inGameHandler(String input) {
        if (input != null && input.equals(Constants.EXIT_COMMAND)) {
            hangmanData.setGameStatus(GameStatus.MENU);
            return;
        }
        if (input == null || input.isBlank() || input.length() != 1) {
            throw new IncorrectLetterSequenceException(
                    Constants.INCORRECT_LETTER_SEQUENCE_MESSAGE
            );
        }
        Character letter = input.toCharArray()[0];
        if (hangmanData.getWrongLetters().contains(letter)
                || hangmanData.getOpenLetters().contains(letter)) {
            throw new LetterAlreadyExistsException(
                    Constants.LETTER_ALREADY_EXISTS_MESSAGE
            );
        }
        if (hangmanData.getHiddenLetters().contains(letter)) {
            hangmanData.getHiddenLetters().remove(letter);
            hangmanData.getOpenLetters().add(letter);
        } else {
            hangmanData.getWrongLetters().add(letter);
            hangmanData.setMistakesCount(hangmanData.getMistakesCount() + 1);
        }
        hangmanData.setAttemptsCount(hangmanData.getAttemptsCount() + 1);
        if (hangmanData.getHiddenLetters().isEmpty()) {
            hangmanData.setGameStatus(GameStatus.WIN);
        }
        if (hangmanData.getMistakesCount().equals(Constants.MAX_COUNT_OF_MISTAKES)) {
            hangmanData.setGameStatus(GameStatus.GAME_OVER);
        }
    }
}

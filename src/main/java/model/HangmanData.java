package model;

import java.util.Set;

public class HangmanData {

    private static HangmanData INSTANCE;

    private GameStatus gameStatus;

    private String word;

    private Integer attemptsCount;

    private Integer mistakesCount;

    private Set<Character> openLetters;

    private Set<Character> hiddenLetters;

    private Set<Character> wrongLetters;

    private RuntimeException exception;

    private HangmanData() {
    }

    public static HangmanData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HangmanData();
        }
        return INSTANCE;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsCount(Integer attemptsCount) {
        this.attemptsCount = attemptsCount;
    }

    public Integer getMistakesCount() {
        return mistakesCount;
    }

    public void setMistakesCount(Integer mistakesCount) {
        this.mistakesCount = mistakesCount;
    }

    public Set<Character> getOpenLetters() {
        return openLetters;
    }

    public void setOpenLetters(Set<Character> openLetters) {
        this.openLetters = openLetters;
    }

    public Set<Character> getHiddenLetters() {
        return hiddenLetters;
    }

    public void setHiddenLetters(Set<Character> hiddenLetters) {
        this.hiddenLetters = hiddenLetters;
    }

    public Set<Character> getWrongLetters() {
        return wrongLetters;
    }

    public void setWrongLetters(Set<Character> wrongLetters) {
        this.wrongLetters = wrongLetters;
    }

    public RuntimeException getException() {
        return exception;
    }

    public void setException(RuntimeException exception) {
        this.exception = exception;
    }
}

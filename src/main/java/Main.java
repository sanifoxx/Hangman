import controller.HangmanController;
import exception.ExceptionHandler;
import model.GameStatus;
import model.HangmanData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HangmanData hangmanData = HangmanData.getInstance();
        HangmanController hangmanController = HangmanController.getInstance();
        ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();
        Scanner sc = new Scanner(System.in);

        while (!GameStatus.EXIT.equals(hangmanData.getGameStatus())) {
            try {
                hangmanController.updateView();
                hangmanController.handleInput(sc.nextLine());

            } catch (RuntimeException e) {
                exceptionHandler.handle(e);
            }
        }
        sc.close();
    }
}

package common;

import java.util.List;

public class Constants {

    public static final String WORDS_FILE = "/words_ru";

    public static final String WELCOME_MESSAGE = "Do you want to play?\n";

    public static final String RELOAD_MESSAGE = "Restart the game?";

    public static final String MENU_YES_OR_NO = "[y] Yes / [n] No\n";

    public static final String MENU_EXIT_TO_MENU = "[exit] Exit to menu\n";

    public static final String STANDARD_INPUT_PATTERN = " > ";

    public static final String ACCEPT_COMMAND = "y";

    public static final String REFUSE_COMMAND = "n";

    public static final String EXIT_COMMAND = "exit";

    public static final List<String> VALID_MENU_COMMANDS = List.of(ACCEPT_COMMAND, REFUSE_COMMAND);

    public static final String UNKNOWN_COMMAND_MESSAGE = "Unknown command. Try again\n";

    public static final String INCORRECT_LETTER_SEQUENCE_MESSAGE = "Incorrect input. Please enter one letter\n";

    public static final String LETTER_ALREADY_EXISTS_MESSAGE = "You have already used this letter. Try another one!\n";

    public static final Integer MAX_COUNT_OF_MISTAKES = 6;

    public static final String UNKNOWN_LETTER_ELEMENT = "_";

    public static final String MISTAKES_DELIMITER = ", ";

    public static final String MISTAKES_AREA_FORMAT = "Mistakes (%d): %s\n";

    public static final String END_GAME_STATISTICS_FORMAT = "Numbers of attempts: %d    Number of mistakes: %d\n";

    public static final String EMPTY_LINE = "\n";

    public static final String FRAME_FORMAT = "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "%s" +
            "\n" +
            "\n" +
            "%s" +
            "%s" +
            "%s" +
            "\n" +
            "%s" +
            "%s" +
            "%s";

    public static final String HANGMAN_LOGO = "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "    __  __    ______    __   __    ______    __    __    ______    __   __\n" +
            "   /\\ \\_\\ \\  /\\  __ \\  /\\ \"-.\\ \\  /\\  ___\\  /\\ \"-./  \\  /\\  __ \\  /\\ \"-.\\ \\\n" +
            "   \\ \\  __ \\ \\ \\  __ \\ \\ \\ \\-.  \\ \\ \\ \\__ \\ \\ \\ \\-./\\ \\ \\ \\  __ \\ \\ \\ \\-.  \\\n" +
            "    \\ \\_\\ \\_\\ \\ \\_\\ \\_\\ \\ \\_\\\\\"\\_\\ \\ \\_____\\ \\ \\_\\ \\ \\_\\ \\ \\_\\ \\_\\ \\ \\_\\\\\"\\_\\\n" +
            "     \\/_/\\/_/  \\/_/\\/_/  \\/_/ \\/_/  \\/_____/  \\/_/  \\/_/  \\/_/\\/_/  \\/_/ \\/_/\n";

    public static final String YOU_WIN_PIC = "\n" +
            "                Yb  dP  dP\"Yb  88   88\n" +
            "                 YbdP  dP   Yb 88   88\n" +
            "                  8P   Yb   dP Y8   8P\n" +
            "                 dP     YbodP  `YbodP'\n" +
            "\n" +
            "                Yb        dP 88 88b 88\n" +
            "                 Yb  db  dP  88 88Yb88\n" +
            "                  YbdPYbdP   88 88 Y88\n" +
            "                   YP  YP    88 88  Y8\n";

    public static final List<String> HANGMAN_PIC = List.of(
            "\n" +
                    "   ______\n" +
                    "   |    |\n" +
                    "   |\n" +
                    "   |\n" +
                    "   |\n" +
                    "   |\n" +
                    " __|_____\n" +
                    " |      |___\n" +
                    " |_________|\n",
            "\n" +
                    "   ______\n" +
                    "   |    |\n" +
                    "   |    O\n" +
                    "   |\n" +
                    "   |\n" +
                    "   |\n" +
                    " __|_____\n" +
                    " |      |___\n" +
                    " |_________|\n",
            "\n" +
                    "   ______\n" +
                    "   |    |\n" +
                    "   |    O\n" +
                    "   |    |\n" +
                    "   |    |\n" +
                    "   |\n" +
                    " __|_____\n" +
                    " |      |___\n" +
                    " |_________|\n",
            "\n" +
                    "   ______\n" +
                    "   |    |\n" +
                    "   |    O\n" +
                    "   |   /|\n" +
                    "   |    |\n" +
                    "   |\n" +
                    " __|_____\n" +
                    " |      |___\n" +
                    " |_________|\n",
            "\n" +
                    "   ______\n" +
                    "   |    |\n" +
                    "   |    O\n" +
                    "   |   /|\\\n" +
                    "   |    |\n" +
                    "   |\n" +
                    " __|_____\n" +
                    " |      |___\n" +
                    " |_________|\n",
            "\n" +
                    "   ______\n" +
                    "   |    |\n" +
                    "   |    O\n" +
                    "   |   /|\\\n" +
                    "   |    |\n" +
                    "   |   /\n" +
                    " __|_____\n" +
                    " |      |___\n" +
                    " |_________|\n",
            "\n" +
                    "   ______                dP\"\"b8    db    8b    d8 888888\n" +
                    "   |    |               dP   `\"   dPYb   88b  d88 88__\n" +
                    "   |    O               Yb  \"88  dP__Yb  88YbdP88 88\"\"\n" +
                    "   |   /|\\               YboodP dP\"\"\"\"Yb 88 YY 88 888888\n" +
                    "   |    |\n" +
                    "   |   / \\                dP\"Yb  Yb    dP 888888 88\"\"Yb\n" +
                    " __|_____                dP   Yb  Yb  dP  88__   88__dP\n" +
                    " |      |___             Yb   dP   YbdP   88\"\"   88\"Yb\n" +
                    " |_________|              YbodP     YP    888888 88  Yb\n"
    );
}

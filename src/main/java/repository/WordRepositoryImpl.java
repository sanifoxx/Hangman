package repository;

import common.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class WordRepositoryImpl implements WordRepository {

    private static WordRepositoryImpl INSTANCE;

    private List<String> words;

    private final Random random;

    private WordRepositoryImpl(Random random) {
        this.random = random;
    }

    public static WordRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WordRepositoryImpl(
                    new Random()
            );
        }
        return INSTANCE;
    }

    @Override
    public String getRandomWord() {
        if (words == null) {
            loadWordsFromFile();
        }
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    private void loadWordsFromFile() {
        words = new ArrayList<>();
        try {
            InputStreamReader fileReader = new InputStreamReader(
                    Objects.requireNonNull(
                            getClass().getResourceAsStream(Constants.WORDS_FILE)
                    )
            );
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {
                String word = bufferedReader.readLine();
                if (word == null || word.isBlank()) {
                    continue;
                }
                words.add(word.trim().toLowerCase());
            }
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package repository;

import common.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
            FileReader fileReader = new FileReader(Constants.PATH_WORDS_FILE);
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

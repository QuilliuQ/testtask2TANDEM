package ru.tandemservice.test.word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class WordServiceTest {
    private final IWordService wordService = WordService.INSTANCE;


    @Test
    void checkBadWord() {
        String badWord = "а роза упала по лапу азора";
        String[] array = badWord.replace(" ", "").split("");
        assertFalse(wordService.checkWord(array));
    }

    @Test
    void checkGoodWord() {
        String badWord = "а роза упала на лапу азора";
        String[] array = badWord.replace(" ", "").split("");
        assertTrue(wordService.checkWord(array));
    }
}

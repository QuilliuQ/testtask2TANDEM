package ru.tandemservice.test.word;


/**
 * Базовая реализация интерфейса {@link IWordService}
 */

public class WordService implements IWordService {

    /**
     * Singleton instance
     */
    public static final IWordService INSTANCE = new WordService();


    /**
     * Метод проверки слова/фразы на палиндром
     * @param input исходный набор символов
     * @return boolean корректности слова
     */
    @Override
    public boolean checkWord(String[] input) {
        for(int i=0;i<input.length/2;i++){
            int elementAtLast = input.length-1-i;
            if(!input[i].equals(input[elementAtLast])){
                return false;
            }
        }
        return true;
    }
}

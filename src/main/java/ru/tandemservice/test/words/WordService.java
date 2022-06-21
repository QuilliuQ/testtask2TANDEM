package ru.tandemservice.test.words;


public class WordService implements IWordService {

    public static final IWordService INSTANSE = new WordService();

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

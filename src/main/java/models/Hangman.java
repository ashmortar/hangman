package models;

import java.util.ArrayList;
import java.util.List;

public class Hangman {

    private String gameWord;

    public Hangman(String input) {
        String[] testArray = {"TOGGLE", "TOGGLE", "TOGGLE", "TOGGLE", "TOGGLE"};
        gameWord = testArray[0];
    }

    public String getWord() {
        return gameWord;
    }

    public Boolean guessLetter(String input) {

        char guess = input.toUpperCase().charAt(0);
        char[] gameWordArray = gameWord.toCharArray();
        Boolean isALetter = null;

        for ( char thing : gameWordArray) {
            if (guess == thing) {
                //this is where a letter (or letters) would be revealed
                isALetter = true;
                break;

            } else {
                //this means the guess was incorrect
                isALetter =  false;
            }
        }
        return isALetter;
    }

}
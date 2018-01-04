package models;

import java.util.ArrayList;
import java.util.List;

public class Hangman {

    private String gameWord;

    public Hangman(String input){
         String[] testArray = {"TOGGLE", "TOGGLE", "TOGGLE", "TOGGLE", "TOGGLE"};
         gameWord = testArray[0];
    }

    public String getWord() {
        return gameWord;
    }

    public Boolean guessLetter(String input) {
        return true;
    }
}

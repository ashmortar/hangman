package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Hangman {
    private String gameWord;
    private String[] gameWordArray;
    private List<String> guessedLetters;
    private Integer remainingGuesses = 10;
    private boolean isLost = false;
    private boolean isWon = false;


    public Hangman(String input) {
        String[] testArray = {"TOGGLE", "TOGGLE", "TOGGLE", "TOGGLE", "TOGGLE"};
        gameWord = testArray[0];
        gameWordArray = gameWord.split("");
        guessedLetters = new ArrayList<String>();
        listBuilder();
    }

    private List<String> gameBoard = new ArrayList<String>();
    private List<String> output = new ArrayList<String>();
    private void listBuilder() {
        for (int i = 0; i < gameWordArray.length; i++) {
            output.add("_");
            gameBoard.add(gameWordArray[i]);
        }
    }

    public String getWord() {
        return gameWord;
    }

    public Boolean guessLetter(String input) {

        String guess = input.toUpperCase();
        Boolean isALetter = null;
        guessedLetters.add(guess);
        remainingGuesses -= 1;

        for ( String thing : gameWordArray) {
            if (guess.equals(thing)) {
                //this is where a letter (or letters) would be revealed
                isALetter = true;
                for ( int i = 0; i < gameWordArray.length; i++) {
                    if (guess.equals(gameWordArray[i])) {
                        output.set(i, guess);
                    }
                }

                break;

            } else {
                //this means the guess was incorrect
                isALetter =  false;
            }
        }
        return isALetter;
    }

    public String showWord() {
        String outputString = String.join(" ", output);
        return outputString;
    }

    public List getGuessedLetters() {
        return guessedLetters;
    }

    public String getTurn() {
        String hereYouGo = "You have " + remainingGuesses.toString() + " guesses remaining";
        return hereYouGo;
    }

    public Boolean hasLost() {
        if (remainingGuesses <= 0) {
            isLost = true;
        }
        return isLost;
    }

    public Boolean hasWon() {
        if (output.equals(gameBoard)) {
            isWon = true;
        }
        return isWon;

    }

}
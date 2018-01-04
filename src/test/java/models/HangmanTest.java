package models;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HangmanTest {
    @Test
    public void newHangman_InstantiatesCorrectly_true() throws Exception {
        Hangman testGame = new Hangman("test");
        assertEquals(true, testGame instanceof Hangman);
    }

    @Test
    public void getWord_returnsCorrectWordForCurrentGame_TOGGLE() throws Exception {
        Hangman testGame = new Hangman("test");
        String expectedOutput = "TOGGLE";
        assertEquals(expectedOutput, testGame.getWord());
    }

    @Test
    public void guessLetter_returnsFalseForLettersNotPresent_false() throws Exception {
        Hangman testGame = new Hangman("test");
        Boolean expectedOutput = false;
        assertEquals(expectedOutput, testGame.guessLetter("m"));
    }

    @Test
    public void guessLetter_reteurnsTrueForLettersThatArePresent_true() throws Exception {
        Hangman testGame = new Hangman("test");
        Boolean expectedOutput = true;
        assertEquals(expectedOutput, testGame.guessLetter("e"));
    }

    @Test
    public void showWord_returnsUnderscoresForLettersNotGuessedAndRevealsGuessedLetters______E() throws Exception {
        Hangman testGame = new Hangman("test");
        testGame.guessLetter("e");
        String expectedOutput = "_ _ _ _ _ E";
        assertEquals(expectedOutput, testGame.showWord());
    }

    @Test
    public void getGuessedLetters_returnsAllLettersGuessed_ME() throws Exception {
        Hangman testGame = new Hangman("test");
        testGame.guessLetter("m");
        testGame.guessLetter("e");
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("M");
        expectedOutput.add("E");
        assertEquals(expectedOutput, testGame.getGuessedLetters());
    }

    @Test
    public void getTurn_returnsNumberOfWrongGuessesLeft_WRONGGUESSESREAMINING8()throws  Exception {
        Hangman testGame = new Hangman("test");
        testGame.guessLetter("m");
        testGame.guessLetter("n");
        String expectedOutput = "You have 8 guesses remaining";
        assertEquals(expectedOutput, testGame.getTurn());
    }

    @Test
    public void hasLost_returnsFalseIfGuessesRemain_false() throws Exception {
        Hangman testGame = new Hangman("test");
        Boolean expectedOutput = false;
        assertEquals(expectedOutput, testGame.hasLost());
    }

    @Test
    public void hasLost_returnsTrueIfNoGuessesRemain_true() throws Exception {
        Hangman testGame = new Hangman("test");
        Boolean expectedOutput = true;
        testGame.guessLetter("a");
        testGame.guessLetter("b");
        testGame.guessLetter("c");
        testGame.guessLetter("d");
        testGame.guessLetter("e");
        testGame.guessLetter("f");
        testGame.guessLetter("g");
        testGame.guessLetter("h");
        testGame.guessLetter("i");
        testGame.guessLetter("j");
        assertEquals(expectedOutput, testGame.hasLost());
    }

    @Test
    public void hasWon_returnsTrueIfWordIsCompleted_true() throws Exception {
        Hangman testGame = new Hangman("test");
        Boolean expectedOutput = true;
        testGame.guessLetter("t");
        testGame.guessLetter("o");
        testGame.guessLetter("g");
        testGame.guessLetter("l");
        testGame.guessLetter("e");
        assertEquals(expectedOutput, testGame.hasWon());
    }
}
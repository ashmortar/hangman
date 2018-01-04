package models;

import org.junit.Test;

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
        assertEquals(expectedOutput, testGame.guessLetter("t"));
    }
}
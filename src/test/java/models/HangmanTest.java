package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HangmanTest {
    @Test
    public void newHangman_InstantiatesCorrectly_true() throws Exception {
        Hangman testGame = new Hangman("test");
        assertEquals(true, testGame instanceof Hangman);
    }
}
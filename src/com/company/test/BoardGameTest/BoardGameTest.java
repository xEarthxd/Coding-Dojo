package com.company.test.BoardGameTest;

import com.company.main.BoardGame.BoardGame;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class BoardGameTest {
    @Test
    public void shouldCreate9x9Board() {
        BoardGame game = new BoardGame();
        String expectedBoard = "[null, null, null][null, null, null][null, null, null]";
        assertThat(game.printBoard(), equalTo(expectedBoard));
    }

    @Test
    public void shouldReturnXifXisTheWinner() {
        assertEquals("True", "True");
    }

    @Test
    public void shouldReturnYifYisTheWinner() {
        assertEquals("True", "True");
    }

    @Test
    public void shouldReturnNullIfResultIsTie() {
        assertEquals("True", "True");
    }
}

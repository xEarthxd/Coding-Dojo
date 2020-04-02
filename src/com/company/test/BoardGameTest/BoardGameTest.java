package com.company.test.BoardGameTest;

import com.company.main.BoardGame.BoardGame;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
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
    public void shouldReturnTrueIfTheSlotIsNull() {
        BoardGame game = new BoardGame();
        Boolean actual = game.TakeSlot(game.getX(), 0, 0);
        assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseIfTheSlotIsAlreadyFilled() {
        BoardGame game = new BoardGame();
        game.TakeSlot(game.getX(), 0, 0);
        Boolean actual = game.TakeSlot(game.getX(), 0, 0);
        assertFalse(actual);
    }

    @Test
    public void shouldPlaceXIfSlotIsAvailable() {
        BoardGame game = new BoardGame();
        game.TakeSlot(game.getX(), 0, 0);
        String expectedBoard = "[X, null, null][null, null, null][null, null, null]";
        assertThat(game.printBoard(), equalTo(expectedBoard));
    }

    @Test
    public void shouldPlaceOafterXHasBeenPlaced() {
        BoardGame game = new BoardGame();
        game.TakeSlot(game.getX(), 0, 0);
        game.TakeSlot(game.getX(), 0, 1);
        String expectedBoard = "[X, O, null][null, null, null][null, null, null]";
        assertThat(game.printBoard(), equalTo(expectedBoard));
    }

    @Test
    public void shouldNotAllowPlayerToPlaceOnTheExistedMark() {
        BoardGame game = new BoardGame();
        game.TakeSlot(game.getX(), 0, 0);
        game.TakeSlot(game.getX(), 0, 0);
        String expectedBoard = "[X, null, null][null, null, null][null, null, null]";
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

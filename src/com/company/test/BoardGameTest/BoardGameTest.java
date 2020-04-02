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
        String expectedBoard = "[ ,  ,  ]\n[ ,  ,  ]\n[ ,  ,  ]\n";
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
        String expectedBoard = "[X,  ,  ]\n[ ,  ,  ]\n[ ,  ,  ]\n";
        assertThat(game.printBoard(), equalTo(expectedBoard));
    }

    @Test
    public void shouldPlaceOafterXHasBeenPlaced() {
        BoardGame game = new BoardGame();
        game.TakeSlot(game.getX(), 0, 0);
        game.TakeSlot(game.getX(), 0, 1);
        String expectedBoard = "[X, O,  ]\n[ ,  ,  ]\n[ ,  ,  ]\n";
        assertThat(game.printBoard(), equalTo(expectedBoard));
    }

    @Test
    public void shouldNotAllowPlayerToPlaceOnTheExistedMark() {
        BoardGame game = new BoardGame();
        game.TakeSlot(game.getX(), 0, 0);
        game.TakeSlot(game.getX(), 0, 0);
        String expectedBoard = "[X,  ,  ]\n[ ,  ,  ]\n[ ,  ,  ]\n";
        assertThat(game.printBoard(), equalTo(expectedBoard));
    }

    @Test
    public void shouldReturnHorizontalWinIfPatternIsRecognized() {
        BoardGame game = new BoardGame();
        game.TakeSlot(true, 1, 0);
        game.TakeSlot(true, 1, 1);
        game.TakeSlot(true, 1, 2);
        System.out.println(game.printBoard());
        Boolean actual = game.getHorizontalWin();
        assertTrue(actual);
    }

//    @Test
//    public void shouldReturnXifXisTheWinner() {
//        BoardGame game = new BoardGame();
//        game.TakeSlot(true, 0, 0);
//        game.TakeSlot(true, 0, 1);
//        game.TakeSlot(true, 0, 2);
//        String expectedResult = "X";
//        assertThat(game.GetWinner(), equalTo(expectedResult));
//    }
//
//    @Test
//    public void shouldReturnYifYisTheWinner() {
//        assertEquals("True", "True");
//    }
//
//    @Test
//    public void shouldReturnNullIfResultIsTie() {
//        assertEquals("True", "True");
//    }
}

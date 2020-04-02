package com.company.test.BoardGameTest;

import com.company.main.BoardGame.Board;
import com.company.main.BoardGame.BoardGame;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BoardTest {
    @Test
    public void shouldInit9x9Board() {
        Board game = new Board();
        String[][] expectedBoard = {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        };
        assertThat(game.getBoard(), equalTo(expectedBoard));
    }

    @Test
    public void shouldReturnCorrectToStringBoard() {
        Board game = new Board();
        String expectedBoard = "[null, null, null][null, null, null][null, null, null]";
        assertThat(game.toString(), equalTo(expectedBoard));
    }

    @Test
    public void shouldPrintBoardWithPlacedMarkWhenCalledPlaceMarkMethod() {
        Board game = new Board();
        game.placeMark('X', 0, 0);
        String expectedBoard = "[X, null, null][null, null, null][null, null, null]";
        assertThat(game.toString(), equalTo(expectedBoard));
    }
}

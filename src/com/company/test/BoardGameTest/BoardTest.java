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
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "},
        };
        assertThat(game.getBoard(), equalTo(expectedBoard));
    }

    @Test
    public void shouldReturnCorrectToStringBoard() {
        Board game = new Board();
        String expectedBoard = "[ ,  ,  ]\n[ ,  ,  ]\n[ ,  ,  ]\n";
        assertThat(game.toString(), equalTo(expectedBoard));
    }

    @Test
    public void shouldReturnSpecificMarkForSpecificRowAndColumn() {
        Board game = new Board();
        String mark = game.getMarkAt(0,0);
        assertThat(mark, equalTo(" "));
    }

    @Test
    public void shouldPrintBoardWithPlacedMarkWhenCalledPlaceMarkMethod() {
        Board game = new Board();
        game.placeMark('X', 0, 0);
        String expectedBoard = "[X,  ,  ]\n[ ,  ,  ]\n[ ,  ,  ]\n";
        assertThat(game.toString(), equalTo(expectedBoard));
    }

    @Test
    public void shouldBeAbleToGetXMarkAfterPlacingIt() {
        Board game = new Board();
        game.placeMark('X', 0, 0);
        String mark = game.getMarkAt(0, 0);
        String expected = "X";
        assertThat(mark, equalTo(expected));
    }
}

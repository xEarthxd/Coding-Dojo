package com.company.test.BoardGameTest;

import com.company.main.BoardGame.Application;
import org.junit.Test;

import java.io.*;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApplicationTest {
    @Test
    public void shouldRenderDefaultBoardWithNumber() {
        Application app = new Application();
        String expected = String.format(
                "| %s | %s | %s |" + "\n" +
                        "-------------" + "\n" +
                        "| %s | %s | %s |" + "\n" +
                        "-------------" + "\n" +
                        "| %s | %s | %s |", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        String actual = app.renderBoard();
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void placeMarkWithOnlyXShouldBeShownOnTheBoard() {
        Application app = new Application();
        String expected = String.format(
                "| %s | %s | %s |" + "\n" +
                        "-------------" + "\n" +
                        "| %s | %s | %s |" + "\n" +
                        "-------------" + "\n" +
                        "| %s | %s | %s |", "X", " ", " ", " ", " ", " ", " ", " ", " ");
        app.placeMark(1);
        String actual = app.refreshBoard();
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void placeMarkWithMultipleXOShouldBeShownOnTheBoard() {
        Application app = new Application();
        String expected = String.format(
                "| %s | %s | %s |" + "\n" +
                        "-------------" + "\n" +
                        "| %s | %s | %s |" + "\n" +
                        "-------------" + "\n" +
                        "| %s | %s | %s |", "X", "O", "X", " ", "O", " ", " ", " ", "X");
        app.placeMark(1);
        app.placeMark(2);
        app.placeMark(3);
        app.placeMark(5);
        app.placeMark(9);
        String actual = app.refreshBoard();
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void testUserInput() throws IOException {
        Application app = new Application();
        String data = "1";
        InputStream stdin = System.in;
        int input;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            input = app.userInput();
        } finally {
            System.setIn(stdin);
        }
        assertThat(input, equalTo(1));
    }

    @Test
    public void testUserInputMark() {
        Application app = new Application();
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int input = app.userInput();
        assertThat(input, equalTo(1));
    }

    @Test
    public void testUserInputInvalid() {
        Application app = new Application();
        String data = "12";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(out));
            app.gameStart();
        } catch (NoSuchElementException e) {
            assertThat(out.toString(), containsString("Input is invalid"));
        }
    }
}
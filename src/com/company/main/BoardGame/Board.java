package com.company.main.BoardGame;

import java.util.Arrays;

public class Board {
    private String[][] board;

    public Board() {
        this.setBoard(new String[][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        });
    }

    public String getMarkAt(int row, int column) {
        return this.board[row][column];
    }

    public void placeMark(Character input, Integer row, Integer column) {
        this.board[row][column] = String.valueOf(input);
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        StringBuilder boardResult = new StringBuilder();
        for(String[] i: this.board) {
            boardResult.append(Arrays.toString(i));
        }
        return boardResult.toString();
    }
}

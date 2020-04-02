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

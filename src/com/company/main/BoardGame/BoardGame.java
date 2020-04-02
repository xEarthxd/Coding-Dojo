package com.company.main.BoardGame;

import java.util.ArrayList;
import java.util.List;

public class BoardGame implements IBoardGame {
    private Boolean isX;
    private Integer row;
    private Integer column;
    private String[][] board;

    public BoardGame() {
        this.setBoard(new String[][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
        });
        this.setX(true);
    }

    @Override
    public String GetWinner() {
        return null;
    }

    @Override
    public Boolean TakeSlot() {
        return null;
    }

    /*
        Getter / Setter Section
    */
    public void setBoard(String[][] board) {
        this.board = board;
    }

    public String[][] getBoard() {
        return board;
    }

    public Boolean getX() {
        return isX;
    }

    public void setX(Boolean x) {
        isX = x;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
}

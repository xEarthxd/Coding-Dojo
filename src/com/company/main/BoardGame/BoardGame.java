package com.company.main.BoardGame;

public class BoardGame implements IBoardGame {
    private Boolean isX;
    private Integer row;
    private Integer column;
    private Board board;

    public BoardGame() {
        this.setBoard(new Board());;
        this.setX(true);
    }

    @Override
    public String GetWinner() {
        return null;
    }

    @Override
    public Boolean TakeSlot(Boolean isX, Integer row, Integer column) {
        if (isX && this.board.getMarkAt(row, column) == null) {
            this.board.placeMark('X', row, column);
            this.changePlayer();
            return true;
        } else if (!isX && this.board.getMarkAt(row, column) == null) {
            this.board.placeMark('O', row, column);
            this.changePlayer();
            return true;
        } else {
            return false;
        }
    }

    public void changePlayer() {
        this.setX(!this.isX);
    }

    /*
        Getter / Setter Section
    */

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

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public String printBoard() {
        return this.getBoard().toString();
    }
}

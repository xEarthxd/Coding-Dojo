package com.company.main.BoardGame;

public class BoardGame implements IBoardGame {
    private Boolean isX;
    private Board board;
    private String winner;
    private int turn;

    public BoardGame() {
        setBoard(new Board());;
        setX(true);
    }

    @Override
    public String GetWinner() {
        if (getHorizontalWin() || getVerticalWin() || getDiagonalWin()) {
            return winner;
        } else {
            return null;
        }
    }

    public Boolean getHorizontalWin() {
        for (int i = 0; i < 3; i++) {
            if ((board.getMarkAt(i, 0).equals(board.getMarkAt(i, 1))) && (board.getMarkAt(i, 1).equals(board.getMarkAt(i, 2))) && (!board.getMarkAt(i, 0).equals(" "))) {
                winner = board.getMarkAt(i, 0);
                return true;
            }
        } return false;
    }

    public Boolean getVerticalWin() {
        for (int i = 0; i < 3; i++) {
            if ((board.getMarkAt(0, i).equals(board.getMarkAt(1, i))) && (board.getMarkAt(1, i).equals(board.getMarkAt(2, i))) && (!board.getMarkAt(0, i).equals(" "))) {
                winner = board.getMarkAt(0, i);
                return true;
            }
        } return false;
    }

    public Boolean getDiagonalWin() {
        if ((board.getMarkAt(0, 0).equals(board.getMarkAt(1, 1))) && (board.getMarkAt(1, 1).equals(board.getMarkAt(2, 2))) && (!board.getMarkAt(0, 0).equals(" "))) {
            winner = board.getMarkAt(0, 0);
            return true;
        }
        if ((board.getMarkAt(0, 2).equals(board.getMarkAt(1, 1))) && (board.getMarkAt(1, 1).equals(board.getMarkAt(2, 0))) && (!board.getMarkAt(0, 2).equals(" "))) {
            winner = board.getMarkAt(0, 2);
            return true;
        } return false;
    }

    @Override
    public Boolean TakeSlot(Boolean isX, Integer row, Integer column) {
        if (isX && board.getMarkAt(row, column) == " ") {
            board.placeMark('X', row, column);
            changePlayer();
            return true;
        } else if (!isX && board.getMarkAt(row, column) == " ") {
            board.placeMark('O', row, column);
            changePlayer();
            return true;
        } else {
            return false;
        }
    }

    public void changePlayer() {
        setX(!isX);
    }

    public Boolean getX() {
        return isX;
    }

    public void setX(Boolean x) {
        isX = x;
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

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}

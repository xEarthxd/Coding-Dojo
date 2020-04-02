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
        if (this.board.getMarkAt(0, 0).equals(this.board.getMarkAt(0, 1)) && this.board.getMarkAt(0, 1).equals(this.board.getMarkAt(0, 2))) {
            System.out.println(this.printBoard());
            return "X";
        } else {
            return null;
        }
    }

    public Boolean getHorizontalWin() {
        for (int i = 0; i < 3; i++) {
            if ((this.board.getMarkAt(i, 0).equals(this.board.getMarkAt(i, 1))) && (this.board.getMarkAt(i, 1).equals(this.board.getMarkAt(i, 2))) && (!this.board.getMarkAt(i, 0).equals(" "))) {
                return true;
            }
        } return false;
    }

    /*
        [0][0], [0][1], [0][2]
        [1][0], [1][1], [1][2]
        [2][0], [2][1], [2][2]

        [0][0], [1][0], [2][0]
        [0][1], [1][1], [2][1]
        [0][2], [1][2], [2][2]

        [0][0], [1][1], [2][2]
        [0][2], [1][1], [2][0]
    * */

    @Override
    public Boolean TakeSlot(Boolean isX, Integer row, Integer column) {
        if (isX && this.board.getMarkAt(row, column) == " ") {
            this.board.placeMark('X', row, column);
            this.changePlayer();
            return true;
        } else if (!isX && this.board.getMarkAt(row, column) == " ") {
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

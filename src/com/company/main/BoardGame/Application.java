package com.company.main.BoardGame;

import java.util.Scanner;

public class Application {
    BoardGame boardGame;

    public Application() {
        this.boardGame = new BoardGame();
    }

    public void run() {
        System.out.println(this.renderBoard());
        System.out.println("========================================================================");
        System.out.println("Player will have to select the position based on the number shown above.");
        System.out.println("========================================================================");
        System.out.println(this.gameStart());
    }

    public String gameStart() {
        while (this.boardGame.GetWinner() == null && this.boardGame.getTurn() < 9) {
            System.out.println(this.refreshBoard());
            int input = this.userInput();
            if (input > 0 && input <= 9) {
                this.placeMark(input);
            } else {
                System.out.println("Input is invalid");
            }
        }
        System.out.println(this.refreshBoard());
        if (this.boardGame.getTurn() >= 9) {
            return "TIE !";
        } else {
            return String.format("%s is the Winner !", this.boardGame.GetWinner());
        }
    }

    public String renderBoard() {
        return String.format(
                "| %s | %s | %s |" + "\n" +
                "-------------" + "\n" +
                "| %s | %s | %s |" + "\n" +
                "-------------" + "\n" +
                "| %s | %s | %s |", "1", "2", "3", "4", "5", "6", "7", "8" ,"9");
    }

    public String refreshBoard() {
        Board board = this.boardGame.getBoard();
        return String.format(
                "| %s | %s | %s |" + "\n" +
                "-------------" + "\n" +
                "| %s | %s | %s |" + "\n" +
                "-------------" + "\n" +
                "| %s | %s | %s |",
                board.getMarkAt(0, 0), board.getMarkAt(0, 1), board.getMarkAt(0, 2),
                board.getMarkAt(1, 0), board.getMarkAt(1, 1), board.getMarkAt(1, 2),
                board.getMarkAt(2, 0), board.getMarkAt(2, 1),board.getMarkAt(2, 2));
    }

    public void placeMark(int position) {
        if (position >= 1 && position <= 3 && this.boardGame.TakeSlot(this.boardGame.getX(), 0, position - 1)) {
            this.boardGame.TakeSlot(this.boardGame.getX(), 0, position - 1);
            this.boardGame.setTurn(this.boardGame.getTurn()+1);
        } else if (position >= 4 && position <= 6 && this.boardGame.TakeSlot(this.boardGame.getX(), 1, position - 4)) {
            this.boardGame.TakeSlot(this.boardGame.getX(), 1, position - 4);
            this.boardGame.setTurn(this.boardGame.getTurn()+1);
        } else if (position >= 7 && position <= 9 && this.boardGame.TakeSlot(this.boardGame.getX(), 2, position - 7)) {
            this.boardGame.TakeSlot(this.boardGame.getX(), 2, position - 7);
            this.boardGame.setTurn(this.boardGame.getTurn()+1);
        } else {
            System.out.println("Already Marked! Please choose another position.");
        }
    }

    public int userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your number: ");
        return sc.nextInt();
    }
}

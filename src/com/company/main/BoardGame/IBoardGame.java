package com.company.main.BoardGame;

public interface IBoardGame {
    public String GetWinner();
    public Boolean TakeSlot(Boolean isX, Integer row, Integer column);
}

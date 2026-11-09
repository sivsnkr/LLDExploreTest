package com.lldDesignPractice.tictactoe;

public class Player {
    private final CellSymbol cellSymbol;

    public Player(CellSymbol cellSymbol) {
        this.cellSymbol = cellSymbol;
    }

    public CellSymbol getPlayerSymbol() {
        return this.cellSymbol;
    }
}

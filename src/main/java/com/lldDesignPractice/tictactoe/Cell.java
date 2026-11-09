package com.lldDesignPractice.tictactoe;

public class Cell {
    private CellSymbol cellSymbol;

    public Cell() {
        this.cellSymbol = CellSymbol.EMPTY;
    }

    public CellSymbol getSymbol() {
        return this.cellSymbol;
    }

    public void setSymbol(CellSymbol cellSymbol) {
        this.cellSymbol = cellSymbol;
    }
}

package com.lldDesignPractice.tictactoe;

public enum CellSymbol {

    X('X'),
    O('O'),
    EMPTY(' ');

    private final char charValue;

    private CellSymbol(char charValue) {
        this.charValue = charValue;
    }

    public char getCharValue() {
        return charValue;
    }
}

package com.lldDesignPractice.Chess;

import java.util.List;

public abstract class Piece {
    private final Colour colour;
    private final String name;

    public Piece(Colour colour, String name) {
        this.colour = colour;
        this.name = name;
    }

    public abstract boolean isValidMove(Cell destination);
    public abstract List<Cell> getValidMoves();

    public Colour getColour() {
        return colour;
    }
}

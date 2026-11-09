package com.lldDesignPractice.Chess;

import java.util.List;

public class HorsePiece extends Piece {
    public HorsePiece(Colour colour) {
        super(colour, "Horse");
    }

    public boolean isValidMove(Cell destination) {
        if(destination.hasSameColourPiece(this.getColour())) throw new IllegalArgumentException("Invalid move");
        return true;
    }

    public List<Cell> getValidMoves() {
        return List.of(new Cell(9, 9));
    }
}

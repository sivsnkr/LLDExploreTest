package com.lldDesignPractice.Chess;

import javax.print.attribute.standard.JobHoldUntil;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<List<Cell>> cells;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.cells.add(new ArrayList<>(size));
            for(int j = 0; j < size; j++) {
                this.cells.get(i).add(new Cell(i, j));
            }
        }
        init();
    }

    private void init() {
        // set the pieces on the board
        for(int i = 0; i < size / 2; i++) {
            for(int j = 0; j < size / 2; j++) {
                this.cells.get(i).get(j).setPiece(new HorsePiece(Colour.BLACK));
            }
        }
    }

    public Cell getCell(int row, int col) {
        if(row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Invalid cell");
        }
        return this.cells.get(row).get(col);
    }

    public void movePiece(Cell startingCell, Cell destination) {
        Piece piece = startingCell.getPiece();
        if(piece == null) {
            throw new IllegalArgumentException("No piece on starting cell");
        }

//        if(destination.getRow() < 0 || destination.getRow() >= size || destination.getCol() < 0 || destination.getCol() >= size) {
//            throw new IllegalArgumentException("Invalid destination cell");
//        }

        if(!piece.isValidMove(destination)) throw new IllegalArgumentException("Invalid move");

        destination.setPiece(piece);
        startingCell.setPiece(null);
    }

    public boolean isCheckMate(Cell start, Cell destination) {
        return false;
    }
}

package com.lldDesignPractice.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<List<Cell>> board;
    private final int board_size;

    public Board(int size) {
        this.board_size = size;
        List<List<Cell>> board = new ArrayList<>();
        for(int i = 0; i < board_size; i++) {
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j < board_size; j++) {
                row.add(new Cell());
            }
            board.add(row);
        }

        this.board = board;
    }

    public boolean isBoardFull() {
        for(List<Cell> row : board) {
            for(Cell cell : row) {
                if(cell.getSymbol() == CellSymbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidCell(int row, int col) {
        return row < 0 || col < 0 || row >= board_size || col >= board_size;
    }

    private void checkRowAndThrow(int row, int col) {
        if(isValidCell(row, col)) throw new IllegalArgumentException("Invalid row and col");
    }

    public CellSymbol getCellSymbol(int row, int col) {
        checkRowAndThrow(row, col);
        return board.get(row).get(col).getSymbol();
    }

    public void setCellSymbol(int row, int col, CellSymbol cellSymbol) {
        checkRowAndThrow(row, col);
        board.get(row).get(col).setSymbol(cellSymbol);
    }

}

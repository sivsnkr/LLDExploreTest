package com.lldDesignPractice.Chess;

import java.util.List;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void move(Cell startPosition, Cell endPosition) {
        if(!startPosition.getPiece().isValidMove(endPosition)) throw new IllegalArgumentException("Invalid move");
        board.movePiece(startPosition, endPosition);
        System.out.println("PieceColour: " + endPosition.getPiece().getColour() + " moved to " + endPosition);
        this.currentPlayer = this.currentPlayer == player1 ? player2 : player1;
        // various checks based on end position
        if(board.isCheckMate(startPosition, endPosition)) throw new IllegalArgumentException("Checkmate");
    }

    public List<Cell> getValidMoves(int row, int col) {
        return this.board.getCell(row, col).getPiece().getValidMoves();
    }

    public Cell getCell(int row, int col) {
        return this.board.getCell(row, col);
    }
}

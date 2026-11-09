package com.lldDesignPractice.Chess;

import java.util.List;

public class ServiceMain {
    public static void main(String[] args) {
        Player player1 = new Player(Colour.BLACK);
        Player player2 = new Player(Colour.WHITE);
        Board board = new Board(10);
        Game newGame = new Game(board, player1, player2);


        List<Cell> nextMoves = newGame.getValidMoves(0, 0);
        Cell currrentCell = newGame.getCell(0, 0);
        newGame.move(currrentCell, nextMoves.getFirst());
    }
}

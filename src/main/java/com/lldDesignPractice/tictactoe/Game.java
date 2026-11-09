package com.lldDesignPractice.tictactoe;

import java.util.List;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final List<IGameWinObserver> winObservers;

    public Game() {
        this.board = new Board(3);
        this.player1 = new Player(CellSymbol.X);
        this.player2 = new Player(CellSymbol.O);
        this.currentPlayer = player1;
        this.winObservers = List.of(new WinCounter());
    }

    private boolean isWinner() {
        // check if any player has won
        return false;
    }

    private boolean checkGameDraw() {
        return board.isBoardFull();
    }

    private void notifyWinObservers() {
        for(IGameWinObserver observer : winObservers) {
            observer.notifyWin(currentPlayer);
        }
    }

    public void makeMove(int row, int col) {
        if(board.isValidCell(row, col)) {
            System.out.println("Invalid move");
        }else {
            board.setCellSymbol(row, col, currentPlayer.getPlayerSymbol());
            if (isWinner()) {
                notifyWinObservers();
                System.out.println("Player " + currentPlayer.getPlayerSymbol() + " wins");
            } else if (checkGameDraw()) {
                System.out.println("Game draw");
            }
            currentPlayer = currentPlayer == player1 ? player2 : player1;
        }
    }
}

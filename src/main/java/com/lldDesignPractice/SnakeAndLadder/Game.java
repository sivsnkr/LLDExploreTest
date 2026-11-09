package com.lldDesignPractice.SnakeAndLadder;

import java.util.*;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private GameStatus gameStatus;

    public Game(Builder builder) {
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.board = new Board(builder.boardSize, builder.boardEntities);
        this.players = new ArrayDeque<>();
        for(int i = 0; i < builder.numPlayers; i++) {
            this.players.add(new Player(i));
        }
    }

    void makeMove(int number) {
        if(gameStatus != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("Game is not in progress");
        }

        Player currentPlayer = this.players.poll();
        this.players.add(currentPlayer);
        if(!board.isValidMove(currentPlayer.getPosition(), number)) {
            return;
        }

        int newPosition = board.getPosition(currentPlayer.getPosition(), number);
        currentPlayer.setPosition(newPosition);
        System.out.println("Player " + currentPlayer.getPlayerNumber() + "moved to " + newPosition);

        if(newPosition == board.getSize()) {
            System.out.println("Player " + currentPlayer.getPlayerNumber() + " wins!");
            this.gameStatus = GameStatus.COMPLETED;
        }
    }

    public static class Builder {
        private List<BoardEntity> boardEntities;
        private int boardSize;
        private int numPlayers;

        public Builder() {
            this.boardEntities = new ArrayList<>();
        }

        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder setNumPlayers(int numPlayers) {
            this.numPlayers = numPlayers;
            return this;
        }

        public <T extends BoardEntity> Builder addBoardEntity(T boardEntity) {
            this.boardEntities.add(boardEntity);
            return this;
        }

        public Game build() {
            if(boardSize <= 0 || numPlayers <= 0) {
                throw new IllegalArgumentException("Board size and number of players must be greater than 0");
            }
            return new Game(this);
        }
    }
}

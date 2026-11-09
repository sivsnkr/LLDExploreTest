package com.lldDesignPractice.SnakeAndLadder;

import java.util.Random;

public class GameMain {
    public static void main(String[] args) {
        Game.Builder builder = new Game.Builder()
                .setBoardSize(100)
                .setNumPlayers(2);

        for(int i = 0; i < 10; i++) {
            builder = builder.addBoardEntity(new Snake(i + 10, i));
        }

        for(int i = 40; i < 50; i++) {
            builder = builder.addBoardEntity(new Ladder(i, i + 10));
        }

        Game game = builder.build();

        for(int i = 0; i < 100; i++) {
            Random random = new Random();
            int number = random.nextInt(6) + 1;
            game.makeMove(number);
        }
    }
}

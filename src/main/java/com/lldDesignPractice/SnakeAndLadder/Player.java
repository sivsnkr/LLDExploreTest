package com.lldDesignPractice.SnakeAndLadder;

public class Player {
    private final int number;
    private int position;

    public Player(int number) {
        this.number = number;
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPlayerNumber() {
        return this.number;
    }
}

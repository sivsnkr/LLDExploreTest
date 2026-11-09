package com.lldDesignPractice.Elevator;

public class Request {
    private final int from;
    private final Direction direction;

    public Request(int from, Direction direction) {
        this.from = from;
        this.direction = direction;
    }

    public int getFrom() {
        return this.from;
    }

    public Direction getDirection() {
        return this.direction;
    }
}

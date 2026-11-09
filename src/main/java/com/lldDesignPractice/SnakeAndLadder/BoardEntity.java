package com.lldDesignPractice.SnakeAndLadder;

public abstract class BoardEntity {
    private final int startPos;
    private final int endPos;

    public BoardEntity(int startPos, int endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }
}

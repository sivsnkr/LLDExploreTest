package com.lldDesignPractice.SnakeAndLadder;

public class Snake extends BoardEntity {
    public Snake(int startPos, int endPos) {
        super(startPos, endPos);
        if(endPos > startPos) throw new IllegalArgumentException("End position cannot be greater than start position");
    }
}

package com.lldDesignPractice.SnakeAndLadder;

public class Ladder extends BoardEntity{
    public Ladder(int startPos, int endPos) {
        super(startPos, endPos);
        if(endPos < startPos) throw new IllegalArgumentException("End position cannot be less than start position");
    }
}

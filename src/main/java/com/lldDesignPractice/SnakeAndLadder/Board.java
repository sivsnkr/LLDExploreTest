package com.lldDesignPractice.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int size;
    private final List<Integer> positions;
    private final List<BoardEntity> boardEntities;

    public Board(int size, List<? extends BoardEntity> boardEntities) {
        this.size = size;
        this.positions = new ArrayList<>(size);
        this.boardEntities = new ArrayList<>();
        this.boardEntities.addAll(boardEntities);
    }

    public boolean isValidMove(int currentPosition, int diceValue) {
        return currentPosition + diceValue <= size;
    }

    public int getPosition(int currentPosition, int diceValue) {
        // a valid position based on board entity
        int newPosition = currentPosition + diceValue;
        for(BoardEntity boardEntity : boardEntities) {
            if(boardEntity.getStartPos() == currentPosition) {
                newPosition = boardEntity.getEndPos();
            }
        }
        return newPosition;
    }

    public int getSize() {
        return size;
    }
}

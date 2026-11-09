package com.lldDesignPractice.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class WinCounter implements IGameWinObserver {

    Map<Player, Integer> winCount;

    public WinCounter() {
        this.winCount = new HashMap<>();
    }

    @Override
    public void notifyWin(Player player) {
        this.winCount.put(player, this.winCount.getOrDefault(player, 0) + 1);
    }
}

package com.lldDesignPractice.StackOverflow;

import java.util.HashMap;
import java.util.Map;

public class UserReputationManager implements IPostReactionListener {
    Map<String, Integer> reputationMap;

    public UserReputationManager() {
        reputationMap = new HashMap<>();
    }


    @Override
    public void notifyReactionAdded(String userId, ReactionType reactionType) {
        int currentReputation = reactionType == ReactionType.UPVOTE ? 1 : -1;
        reputationMap.put(userId, reputationMap.getOrDefault(userId, 0) + currentReputation);
    }

    public int getUserReputation(String userId) {
        return reputationMap.getOrDefault(userId, 0);
    }
}

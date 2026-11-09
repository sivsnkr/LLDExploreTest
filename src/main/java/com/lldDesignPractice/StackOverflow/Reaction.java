package com.lldDesignPractice.StackOverflow;

public class Reaction {
    private final ReactionType type;
    private final String userId;

    public Reaction(ReactionType reactionType, String userId) {
        this.type = reactionType;
        this.userId = userId;
    }

    public boolean doTypeMatch(ReactionType type) {
        return this.type == type;
    }

    public ReactionType getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }
}

package com.lldDesignPractice.StackOverflow;

public interface IPostReactionListener {
    void notifyReactionAdded(String userId, ReactionType reactionType);
}

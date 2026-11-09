package com.lldDesignPractice.StackOverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Post {
    private static final AtomicInteger postIdCounter = new AtomicInteger(0);
    private final int postId;
    private final String userId;
    private String body;
    private final List<Reaction> reactions;
    private IPostReactionListener reactionListener;

    protected Post(String userId, String body) {
        this.postId = postIdCounter.getAndIncrement();
        this.userId = userId;
        this.body = body;
        this.reactions = new ArrayList<>();
    }

    public void subscribeToReaction(IPostReactionListener iPostReactionListener) {
        this.reactionListener = iPostReactionListener;
    }

    public int getPostId() {
        return this.postId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void addReaction(Reaction reaction) {
        this.reactions.add(reaction);
        this.reactionListener.notifyReactionAdded(this.userId, reaction.getType());
    }

    public int getReactionsCount() {
        long upvotecount = this.reactions.stream().filter(reaction -> reaction.doTypeMatch(ReactionType.UPVOTE)).count();
        long downvotecount = this.reactions.stream().filter(reaction -> reaction.doTypeMatch(ReactionType.DOWNVOTE)).count();

        return (int) (upvotecount - downvotecount);
    }
}

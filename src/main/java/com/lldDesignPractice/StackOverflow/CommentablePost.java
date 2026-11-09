package com.lldDesignPractice.StackOverflow;

import java.util.ArrayList;
import java.util.List;

public abstract class CommentablePost extends Post {

    private final List<Comment> comments;

    protected CommentablePost(String userId, String body) {
        super(userId, body);
        this.comments = new ArrayList<>();
    }
}

package com.lldDesignPractice.StackOverflow;

import java.util.ArrayList;
import java.util.List;

public class Question extends  CommentablePost {
    private final List<Answer> answers;

    public Question(String userId, String body) {
        super(userId, body);
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public boolean isMatchQuestionText(String questionText) {
        return this.getBody().equals(questionText);
    }
}

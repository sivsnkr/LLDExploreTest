package com.lldDesignPractice.StackOverflow;

import java.util.HashMap;
import java.util.Map;

public class StackOverflowService {

    Map<Integer, Question> qUestionMap;
    Map<Integer, Answer> answerMap;
    UserReputationManager userReputationManager;

    public StackOverflowService() {
        this.userReputationManager = new UserReputationManager();
        this.qUestionMap = new HashMap<>();
        this.answerMap = new HashMap<>();
    }

    public void postQuestion(Question question) {
        question.subscribeToReaction(userReputationManager);
        qUestionMap.put(question.getPostId(), question);
    }

    public void postAnswer(int questionId, Answer answer) {
        if(!qUestionMap.containsKey(questionId)) throw new IllegalArgumentException("Question does not exist");
        answer.subscribeToReaction(userReputationManager);
        Question question = qUestionMap.get(questionId);
        question.addAnswer(answer);
        answerMap.put(answer.getPostId(), answer);
    }

    public void addReaction(int postId, Reaction reaction) {
        if(answerMap.containsKey(postId)) {
            answerMap.get(postId).addReaction(reaction);
        }else if(qUestionMap.containsKey(postId)) {
            qUestionMap.get(postId).addReaction(reaction);
        } else {
            throw new IllegalArgumentException("Post does not exist");
        }
    }

    public int getPostReaction(int postId) {
        if(answerMap.containsKey(postId)) {
            return answerMap.get(postId).getReactionsCount();
        }else if(qUestionMap.containsKey(postId)) {
            return qUestionMap.get(postId).getReactionsCount();
        } else {
            throw new IllegalArgumentException("Post does not exist");
        }
    }

    public int getUserReputation(String userId) {
        return userReputationManager.getUserReputation(userId);
    }

}

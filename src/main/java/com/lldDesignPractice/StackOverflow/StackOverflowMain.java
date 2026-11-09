package com.lldDesignPractice.StackOverflow;

import javax.sound.midi.SysexMessage;
import java.util.Map;

public class StackOverflowMain {
    public static void main(String[] args) {
        String userId = "1";
        String userId1 = "2";
        String userId2 = "3";
        StackOverflowService stackOverflowService = new StackOverflowService();
        Question question = new Question(userId, "What is Java?");
        Answer answer = new Answer(userId1, "Java is a programming language.");
        Answer answer1 = new Answer(userId2, "Java is a object oriented programming language.");
        Reaction reaction = new Reaction(ReactionType.UPVOTE, userId);
        Reaction reaction1 = new Reaction(ReactionType.DOWNVOTE, userId2);

        stackOverflowService.postQuestion(question);
        stackOverflowService.postAnswer(question.getPostId(), answer);
        stackOverflowService.postAnswer(question.getPostId(), answer1);

        stackOverflowService.addReaction(answer.getPostId(), reaction);
        stackOverflowService.addReaction(answer.getPostId(), reaction1);
        stackOverflowService.addReaction(answer.getPostId(), reaction);

        System.out.printf("Count of reaction on answer1: %d\n", stackOverflowService.getPostReaction(answer.getPostId()));
        System.out.printf("UserId2 reputation: %d\n", stackOverflowService.getUserReputation(userId1));
    }
}

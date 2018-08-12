package org.aplusstudios.com.biologytrivia.model;

public class Answer {

    private String answer;
    private int answerId;
    private int questionId;

    public Answer(String answer, int answerId, int questionId) {
        this.answer = answer;
        this.answerId = answerId;
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}

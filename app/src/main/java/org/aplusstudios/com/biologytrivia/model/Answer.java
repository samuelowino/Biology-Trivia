package org.aplusstudios.com.biologytrivia.model;

public class Answer {

    private String answer;
    private int answerId;
    private int questionId;
    private boolean isCorrectAnswer;

    public Answer(String answer, int answerId, int questionId,boolean isCorrectAnswer) {
        this.answer = answer;
        this.answerId = answerId;
        this.questionId = questionId;
        this.isCorrectAnswer = isCorrectAnswer;
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

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        isCorrectAnswer = correctAnswer;
    }
}

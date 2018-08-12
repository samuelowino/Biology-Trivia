package org.aplusstudios.com.biologytrivia.model;

public class Question {

    private int levelNumber;
    private int questionNumber;
    private String questionText;
    private String correctAnswer;
    private String answerOptionA;
    private String answerOptionB;
    private String answerOptionC;
    private String answerOptionD;

    public Question(int levelNumber, int questionNumber, String questionText, String correctAnswer, String answerOptionA, String answerOptionB, String answerOptionC, String answerOptionD) {
        this.levelNumber = levelNumber;
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.answerOptionA = answerOptionA;
        this.answerOptionB = answerOptionB;
        this.answerOptionC = answerOptionC;
        this.answerOptionD = answerOptionD;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerOptionA() {
        return answerOptionA;
    }

    public void setAnswerOptionA(String answerOptionA) {
        this.answerOptionA = answerOptionA;
    }

    public String getAnswerOptionB() {
        return answerOptionB;
    }

    public void setAnswerOptionB(String answerOptionB) {
        this.answerOptionB = answerOptionB;
    }

    public String getAnswerOptionC() {
        return answerOptionC;
    }

    public void setAnswerOptionC(String answerOptionC) {
        this.answerOptionC = answerOptionC;
    }

    public String getAnswerOptionD() {
        return answerOptionD;
    }

    public void setAnswerOptionD(String answerOptionD) {
        this.answerOptionD = answerOptionD;
    }
}

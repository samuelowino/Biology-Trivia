package org.aplusstudios.com.biologytrivia.model;

public class Level {

    private int number;
    private boolean started;
    private boolean completed;
    private String levelTitle;

    public Level(int number, boolean started, boolean completed, String levelTitle) {
        this.number = number;
        this.started = started;
        this.completed = completed;
        this.levelTitle = levelTitle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getLevelTitle() {
        return levelTitle;
    }

    public void setLevelTitle(String levelTitle) {
        this.levelTitle = levelTitle;
    }
}

package com.cunningbird;

abstract public class Account {

    private double score;

    public Account(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getInfo() {
        return "Account Score: " + this.score;
    }
}

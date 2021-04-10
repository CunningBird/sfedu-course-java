package com.cunningbird;

public class CheckingAccount extends Account {

    private final double lastPayment;

    public CheckingAccount(double score, double lastPayment) {
        super(score);
        this.lastPayment = lastPayment;
    }

    @Override
    public String getInfo() {
        return "Checking Account \n" +
                "Account Score: " + this.getScore() + "\n" +
                "Last payment: " + this.lastPayment;
    }
}

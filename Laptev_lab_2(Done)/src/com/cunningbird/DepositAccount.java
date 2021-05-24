package com.cunningbird;

public class DepositAccount extends Account {

    private final double depositRate;

    public DepositAccount(double score, double depositRate) {
        super(score);
        this.depositRate = depositRate;
    }

    @Override
    public String getInfo() {
        return "Checking Account \n" +
                "Account Score: " + this.getScore() + "\n" +
                "Deposit payment: " + this.depositRate;
    }
}

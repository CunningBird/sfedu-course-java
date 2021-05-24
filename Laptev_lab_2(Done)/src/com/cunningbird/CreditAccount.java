package com.cunningbird;

public class CreditAccount extends Account {

    private final double debt;

    public CreditAccount(double score, double debt) {
        super(score);
        this.debt = debt;
    }

    @Override
    public String getInfo() {
        return "Checking Account \n" +
                "Account Score: " + this.getScore() + "\n" +
                "Debt: " + this.debt;
    }
}

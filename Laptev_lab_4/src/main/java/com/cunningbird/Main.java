package com.cunningbird;

public class Main {

    public static void main(String[] args) throws Exception {
        Expression expression1 = new Expression("15 * (3 - 4)");
        Expression expression2 = new Expression("92 / 10");

        System.out.println(expression1.getResult());
        System.out.println(expression2.getResult());
    }
}

package com.cunningbird;

public class Main {

    public static void main(String[] args) throws Exception {
        StringWithBrackets string1 = new StringWithBrackets("<String>(with){right}[brackets]");
        StringWithBrackets string2 = new StringWithBrackets("<String>(with)}wrong{]brackets]");

        System.out.println("String 1 validation is: " + string1.validate());
        System.out.println("String 2 validation is: " + string2.validate());

        Expression expression1 = new Expression("15 * (3 — 4)");
        Expression expression2 = new Expression("92 / 10");

        System.out.println(expression1.convertRPN());
        System.out.println(expression2.convertRPN());
    }
}

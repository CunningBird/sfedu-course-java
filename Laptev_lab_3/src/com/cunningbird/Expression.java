package com.cunningbird;

import java.util.*;

public class Expression {

    private final String operators = "+-*/";

    private final String delimiters = "() " + operators;

    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public List<String> convertRPN() throws Exception {
        List<String> rpn = new ArrayList<>();
        MyCharStack stack = new MyCharStack(expression.length());
        StringTokenizer tokenizer = new StringTokenizer(expression, delimiters, true);

        while (tokenizer.hasMoreTokens()) {
            String current = tokenizer.nextToken();

            if (!tokenizer.hasMoreTokens() && isOperator(current)) {
                throw new Exception("Incorrect expression");
            }

            if (current.equals(" ")) {
                continue;
            }

            if (isDelimiter(current)) {
                if (current.equals("(")) stack.push(current.charAt(0));
                else if (current.equals(")")) {
                    while (!(stack.readTop() == '(')) {
                        rpn.add(String.valueOf(stack.pop()));
                        if (stack.isEmpty()) {
                            throw new Exception("Wrong brackets");
                        }
                    }
                    stack.pop();
                    if (!stack.isEmpty()) {
                        rpn.add(String.valueOf(stack.pop()));
                    }
                } else {
                    while (!stack.isEmpty() && (priority(current) <= priority(String.valueOf(stack.readTop())))) {
                        rpn.add(String.valueOf(stack.pop()));
                    }
                    stack.push(current.charAt(0));
                }
            } else {
                rpn.add(current);
            }
        }

        while (!stack.isEmpty()) {
            if (isOperator(String.valueOf(stack.readTop()))) {
                rpn.add(String.valueOf(stack.pop()));
            } else {
                throw new Exception("Wrong brackets");
            }
        }

        return rpn;
    }

    private boolean isDelimiter(String token) {
        if (token.length() != 1) {
            return false;
        }
        for (int i = 0; i < delimiters.length(); i++) {
            if (token.charAt(0) == delimiters.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOperator(String token) {
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private int priority(String token) {
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }
}

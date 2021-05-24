package com.cunningbird;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Expression {

    private final String operators = "+-*/";

    private final String delimiters = "() " + operators;

    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public List<String> getRPN() throws Exception {
        List<String> rpn = new ArrayList<>();
        IMyStack<String> stack = new MyStack<>(this.expression.length());
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
                if (current.equals("(")) stack.push(current);
                else if (current.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        rpn.add(stack.pop());
                        if (stack.isEmpty()) {
                            throw new Exception("Wrong brackets");
                        }
                    }
                    stack.pop();
                } else {
                    stack.push(current);
                }
            } else {
                rpn.add(current);
            }
        }

        while (!stack.isEmpty()) {
            if (isOperator(String.valueOf(stack.peek()))) {
                rpn.add(String.valueOf(stack.pop()));
            } else {
                throw new Exception("Wrong brackets");
            }
        }

        return rpn;
    }

    public double getResult() throws Exception {
        List<String> rpn = this.getRPN();
        IMyStack<Double> stack = new MyStack<>(rpn.size());

        for (String x : rpn) {
            if (x.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (x.equals("-")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a - b);
            }
            else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
            else if (x.equals("/")) {
                Double b = stack.pop(), a = stack.pop();
                stack.push(a / b);
            }
            else stack.push(Double.valueOf(x));
        }
        return stack.pop();
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

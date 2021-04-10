package com.cunningbird;

public class StringWithBrackets {

    private final MyCharStack stack;

    private final String string;

    public StringWithBrackets(String string) {
        this.stack = new MyCharStack(string.length());
        this.string = string;
    }

    private boolean isOpeningBracket(char bracket) {
        return "({[<".indexOf(bracket) != -1;
    }

    private boolean isClosingBracket(char bracket) {
        return ")}]>".indexOf(bracket) != -1;
    }

    private boolean isPair(char opening, char closing) {
        return opening == '(' && closing == ')' || opening == '['
                && closing == ']' || opening == '{' && closing == '}' || opening == '<' && closing == '>';
    }

    public boolean validate() {
        for (char c : this.string.toCharArray()) {
            if (isClosingBracket(c) && stack.isEmpty()) {
                return false;
            }
            if (isOpeningBracket(c)) {
                stack.push(c);
            }
            if (isClosingBracket(c)) {
                if (isPair(stack.readTop(), c)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

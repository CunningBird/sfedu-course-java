package com.cunningbird;

import java.lang.Character;
import java.util.Iterator;

public class MyCharStack {

    private final int size;

    private final Character[] stackArray;

    private int top;

    public MyCharStack(int size) {
        this.size = size;
        this.top = -1;
        stackArray = new Character[size];
    }

    public void add(char element) {
        stackArray[++top] = element;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char readTop() {
        return stackArray[top];
    }

    public char remove(int index) {
        char element = stackArray[index];
        stackArray[index] = null;

        for (int i = index + 1; i < stackArray.length - 1; i++) {
            stackArray[i - 1] = stackArray[i];
            stackArray[i] = null;
        }

        return element;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public Iterator<Character> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Character> {
        int cursor;
        int lastRet = -1;

        public boolean hasNext() {
            return cursor != size;
        }

        public Character next() {
            int i = cursor;
            cursor = i + 1;
            return stackArray[lastRet = i];
        }

        public void remove() {
            if (lastRet == -1)
                throw new IllegalStateException();
            MyCharStack.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }

}

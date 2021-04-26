package com.cunningbird;

import java.lang.Character;
import java.util.Iterator;

public class MyCharStack {

    private final Character[] elementData;

    private int count;

    public MyCharStack(int size) {
        count = 0;
        elementData = new Character[size];
    }

    public boolean push(char element) {
        if (elementData.length <= count) {
            return false;
        }

        elementData[count++] = element;

        return true;
    }

    public Character pop() {
        if (count > 0) {
            return elementData[--count];
        }

        return null;
    }

    public Character peek() {
        if (count == 0) {
            return null;
        }

        return elementData[count-1];
    }

    public char remove(int index) {
        char element = elementData[index];
        elementData[index] = null;

        for (int i = index + 1; i < elementData.length - 1; i++) {
            elementData[i - 1] = elementData[i];
            elementData[i] = null;
        }

        return element;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public Iterator<Character> iterator() {
        return new Itr();
    }

    public int getCount() {
        return count;
    }

    private class Itr implements Iterator<Character> {
        int cursor;
        int lastRet = -1;

        public boolean hasNext() {
            return cursor != elementData.length;
        }

        public Character next() {
            int i = cursor;
            cursor = i + 1;
            return elementData[lastRet = i];
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

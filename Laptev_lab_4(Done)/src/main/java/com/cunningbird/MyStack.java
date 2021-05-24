package com.cunningbird;

public class MyStack<E> implements IMyStack<E> {

    protected Object[] elementData;

    private int count;

    public MyStack(int size) {
        count = 0;
        elementData = new Object[size];
    }

    public boolean push(E element) {
        if (elementData.length <= count) {
            return false;
        }

        elementData[count++] = element;

        return true;
    }

    public E pop() {
        if (count > 0) {
            return elementData(--count);
        }

        return null;
    }

    public E peek() {
        if (count == 0) {
            return null;
        }

        return elementData(count-1);
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int getCount() {
        return count;
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }
}

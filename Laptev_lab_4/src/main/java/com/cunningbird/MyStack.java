package com.cunningbird;

public class MyStack<E> implements IMyStack<E> {

    protected Object[] elementData;

    private int top;

    public MyStack(int size) {
        this.top = -1;
        elementData = new Object[size];
    }

    public void push(E element) {
        elementData[++top] = element;
    }

    public E pop() {
        return elementData(top--);
    }

    public E readTop() {
        return elementData(top);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }
}

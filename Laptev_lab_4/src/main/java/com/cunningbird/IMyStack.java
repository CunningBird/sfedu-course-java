package com.cunningbird;

public interface IMyStack<E> {
    void push(E element);

    E pop();

    E readTop();

    boolean isEmpty();
}

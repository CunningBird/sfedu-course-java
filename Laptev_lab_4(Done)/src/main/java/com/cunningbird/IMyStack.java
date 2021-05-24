package com.cunningbird;

public interface IMyStack<E> {
    boolean push(E element);

    E pop();

    E peek();

    boolean isEmpty();

    public int getCount();
}

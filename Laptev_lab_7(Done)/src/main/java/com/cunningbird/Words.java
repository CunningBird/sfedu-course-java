package com.cunningbird;

import java.util.Comparator;
import java.util.TreeSet;

public final class Words extends TreeSet<Word> {

    public Words() {
        super();
    }

    public Words(Comparator<Word> comparator) {
        super(comparator);
    }

    public void read(String text) {
        clear();
        String[] array = text.split(" ");
        for (String el : array)
            add(new Word(el));
    }

    @Override
    public String toString() {
        StringBuilder accumulator = new StringBuilder();
        for (Word el : this) {
            accumulator.append("(").append(el.toString()).append(")");
        }
        return accumulator.toString();
    }
}

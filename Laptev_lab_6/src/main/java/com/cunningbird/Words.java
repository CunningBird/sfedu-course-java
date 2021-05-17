package com.cunningbird;

import java.util.HashSet;

public final class Words extends HashSet<Word> {

    public Words() {
        super();
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

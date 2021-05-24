package com.cunningbird;

import java.util.Objects;

public class Word implements Comparable<Word> {

    private final String string;

    public Word(String str) {
        string = str.split(" ")[0];
    }

    public int length() {
        return string.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return string.equals(word.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public int compareTo(Word o) {
        return string.charAt(0) - o.string.charAt(0);
    }

    @Override
    public String toString() {
        return string;
    }
}

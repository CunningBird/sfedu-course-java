package com.cunningbird;

public class Word implements Comparable<Word> {

    private final String string;

    public Word(String str) {
        string = str.split(" ")[0];
    }

    public int length() {
        return string.length();
    }

    @Override
    public int hashCode(){
        int hashcode = 0;
        for (char ch : string.toCharArray()) {
            hashcode += ch;
        }
        return hashcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            return hashCode() == obj.hashCode();
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Word o) {
        return hashCode() - o.hashCode();
    }

    @Override
    public String toString() {
        return string;
    }
}

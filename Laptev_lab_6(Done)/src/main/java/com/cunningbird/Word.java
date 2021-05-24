package com.cunningbird;

public class Word {

    private final String string;

    public Word(String str) {
        string = str.split(" ")[0];
    }

    @Override
    public int hashCode() {
        return string.length();
    }

    /*@Override
    public int hashCode() {
        int hashcode = 0;
        for (char ch : string.toCharArray()) {
            hashcode += ch;
        }
        return hashcode;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            return hashCode() == obj.hashCode();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return string;
    }
}

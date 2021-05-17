package com.cunningbird;

import java.util.Comparator;

public class WordLettersCountComparator implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {
        return o2.length() - o1.length();
    }
}

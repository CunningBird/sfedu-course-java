package com.cunningbird;

import java.util.Comparator;

public class WordLettersCountComparator implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        int difference = o1.length() - o2.length();
        return (difference == 0) ? 1 : difference;
    }
}

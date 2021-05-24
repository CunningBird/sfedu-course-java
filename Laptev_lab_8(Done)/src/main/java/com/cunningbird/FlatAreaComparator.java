package com.cunningbird;

import java.util.Comparator;

public class FlatAreaComparator implements Comparator<Flat> {

    @Override
    public int compare(Flat o1, Flat o2) {
        return o2.getSquare() - o1.getSquare();
    }
}

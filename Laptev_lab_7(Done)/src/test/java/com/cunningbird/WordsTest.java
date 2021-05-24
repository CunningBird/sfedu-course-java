package com.cunningbird;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordsTest {

    @Test
    public void wordsTest() {
        Words actual = new Words();
        actual.read("1337 qwerty qwerty flex party 01zwe2 95");
        assertEquals(actual.toString(), "(qwerty)(95)(1337)(flex)(party)(01zwe2)");
    }

    @Test
    public void sortTest() {
        Words actual = new Words(new WordLettersCountComparator());
        actual.read("1337 qwerty qwerty flex party 01zwe2 95");
        System.out.println(actual);
        assertEquals(actual.toString(), "(95)(1337)(flex)(party)(qwerty)(01zwe2)");
    }
}
package com.cunningbird;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class WordsTest {

    @Test
    public void wordsTest() {
        Words actual = new Words();
        actual.read("1337 qwerty qwerty flex party 01zwe2 95");

        System.out.println(actual);

        assertEquals(actual.toString(), "(95)(1337)(flex)(01zwe2)(party)(qwerty)");
    }

    @Test
    public void sortTest() {
        Words actual = new Words(new WordLettersCountComparator());
        actual.read("1337 qwerty qwerty flex party 01zwe2 95");

        System.out.println(actual);

        //HashSet<Word> expected = new HashSet<>();
        //expected.add(new Word("95"));
        //expected.add(new Word("1337"));
        //expected.add(new Word("party"));
        //expected.add(new Word("qwerty"));

        //expected.add(new Word("flex"));
        //expected.add(new Word("01zwe2"));

        //assertEquals(actual, expected);
    }
}
package com.cunningbird;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordsTest {

    @Test
    public void wordsTest() {
        Words actual = new Words();
        actual.read("1337 qwerty qwerty flex party 01zwe2 95");

        assertEquals(actual.toString(), "(95)(1337)(flex)(01zwe2)(party)(qwerty)");
    }
}
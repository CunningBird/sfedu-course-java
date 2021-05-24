package com.cunningbird;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class LettersMyTest {

    @Test
    public void size() {
        Collection<Character> col;

        col = new Letters("12345");
        assertEquals(5, col.size());

        col = new Letters("");
        assertEquals(0, col.size());

        col = new Letters("12345");
        assertEquals(5, col.size());

        col = new Letters("1");
        assertEquals(1, col.size());
    }

    @Test
    public void add() {
        Collection<Character> col;

        col = new Letters("qw");
        col.add('1');
        assertEquals("qw1", col.toString());
        assertEquals(3, col.size());

        col = new Letters("qw");
        col.addAll(new Letters("123"));
        assertEquals("qw123", col.toString());
        assertEquals(5, col.size());

        col = new Letters("qw");
        col.addAll(new Letters("1"));
        assertEquals("qw1", col.toString());
        assertEquals(3, col.size());
    }

    @Test
    public void remove() {
        Collection<Character> col;

        col = new Letters("142345");
        col.remove('4');
        assertEquals("12345", col.toString());

        col = new Letters("142345");
        col.removeAll(new Letters("4"));
        assertEquals("1235", col.toString());

        col = new Letters("444");
        col.removeAll(new Letters("4"));
        assertEquals(0, col.size());
    }
}


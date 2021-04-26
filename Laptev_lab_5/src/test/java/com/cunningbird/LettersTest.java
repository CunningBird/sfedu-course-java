package com.cunningbird;

import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;

public class LettersTest {

    Letters col;

    public LettersTest() {
    }

    @Test
    public void testEmptySize1() {
        col = new Letters();
        assertEquals(0, col.size());
    }

    @Test
    public void testEmptySize2() {
        col = new Letters("");
        assertEquals(0, col.size());
    }

    @Test
    public void testSize1() {
        col = new Letters("12345");
        assertEquals(5, col.size());
    }

    @Test
    public void testSize2() {
        col = new Letters("1");
        assertEquals(1, col.size());
    }

    @Test
    public void testAdd() {
        col = new Letters("qw");
        col.add(new Letters("1"));
        assertEquals("qw1", col.toString());
        assertEquals(3, col.size());
    }


    @Test
    public void testAddAll() {
        col = new Letters("qw");
        col.addAll(new Letters("123"));
        assertEquals("qw123", col.toString());
        assertEquals(5, col.size());
    }

    @Test
    public void testClear() {
        col = new Letters("qw");
        col.clear();
        assertEquals(0, col.size());
    }

    @Test
    public void testLettersType() {
        col = new Letters("12345");
        if (!(col.iterator().next() instanceof Character)) {
            fail("Returned value is not a Character");
        }
    }

    @Test
    public void testIteratorNext() {
        Iterator<Character> cl = new Letters("123").iterator();
        assertEquals("1", cl.next().toString());
        assertEquals("2", cl.next().toString());
        assertEquals("3", cl.next().toString());
    }

    @Test
    public void testIteratorHasNext1() {
        Iterator<Character> cl = new Letters("1").iterator();
        assertEquals(true, cl.hasNext());
        cl.next();
        assertEquals(false, cl.hasNext());
    }

    @Test
    public void testIteratorHasNext2() {
        Iterator<Character> c2 = new Letters().iterator();
        assertEquals(false, c2.hasNext());
    }

    @Test
    public void testIteratorClear() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        assertEquals(true, cl.hasNext());
        col.clear();
        assertNull(cl);
    }

    @Test
    public void testTwoIterators() {
        col = new Letters("123");
        Iterator<Character> c1 = col.iterator();
        Iterator<Character> c2 = col.iterator();
        assertEquals(c1.hasNext(), c2.hasNext());
        assertEquals("1", c1.next().toString());
        assertEquals("1", c2.next().toString());
        c1.next();
        assertEquals("3", c1.next().toString());
        assertEquals("2", c2.next().toString());
        assertTrue(c2.hasNext());
        assertFalse(c1.hasNext());
    }


    @Test(expected = Exception.class)
    public void testIteratorException() {
        Iterator<Character> cl = new Letters("12").iterator();
        assertEquals("1", cl.next().toString());
        assertEquals("2", cl.next().toString());
        assertEquals("1", cl.next().toString());
    }

    @Test
    public void testDoubleUsing() {
        col = new Letters("12345");
        int i = 0;
        for (Object c : col) {
            i++;
        }
        for (Object c : col) {
            i++;
        }
        assertEquals(10, i);
    }

    @Test
    public void testRemove() {
        col = new Letters("142345");
        col.remove(new Letters("4"));
        assertEquals("12345", col.toString());
    }

    @Test
    public void testRemoveAll() {
        col = new Letters("142345");
        col.removeAll(new Letters("4"));
        assertEquals("1235", col.toString());
    }

    @Test
    public void testRemoveAll1() {
        col = new Letters("444");
        col.removeAll(new Letters("4"));
        assertEquals(0, col.size());
    }

    @Test
    public void testRemoveAll2() {
        col = new Letters("414243");
        col.removeAll(new Letters("4"));
        assertEquals("123", col.toString());
    }

    @Test(expected = Exception.class)
    public void testIllegalIteratorRemove() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        cl.remove();
    }

    @Test
    public void testIllegalIteratorRemove1() {
        col = new Letters("123");
        Iterator<Character> cl = col.iterator();
        try {
            cl.remove();
            fail("Remove without next");
        } catch (Exception e) {

        }
        assertEquals(3, col.size());
        cl.next();
        cl.remove();
        assertEquals(2, col.size());
        try {
            cl.remove();
            fail("Remove without next");
        } catch (Exception e) {

        }
        assertEquals(2, col.size());
    }

    @Test
    public void testCorrectRetain() {
        col = new Letters("qwerty");
        col.retainAll(new Letters("bgtredcv"));
        assertEquals("ert", col.toString());
    }
}
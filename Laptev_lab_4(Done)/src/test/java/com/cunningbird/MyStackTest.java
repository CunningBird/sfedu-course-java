package com.cunningbird;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MyStackTest {

    private final String[] test = { "Aa", "Bb", "Cc", "Dd" };

    @Test
    public void push() {
        MyStack<String> stack = new MyStack<>(3);
        assertTrue(stack.push(test[0]));
        assertEquals(stack.getCount(), 1);

        assertTrue(stack.push(test[1]));
        assertEquals(stack.getCount(), 2);


        assertTrue(stack.push(test[2]));
        assertEquals(stack.getCount(), 3);

        assertFalse(stack.push(test[3]));
        assertEquals(stack.getCount(), 3);

    }

    @Test
    public void pop() {
        MyStack<String> stack = new MyStack<>(3);
        assertTrue(stack.push(test[0]));
        assertTrue(stack.push(test[1]));
        assertTrue(stack.push(test[2]));

        assertSame(stack.pop(), test[2]);
        assertEquals(stack.getCount(), 2);

        assertSame(stack.pop(), test[1]);
        assertEquals(stack.getCount(), 1);

        assertSame(stack.pop(), test[0]);
        assertEquals(stack.getCount(), 0);

        assertNull(stack.pop());
        assertEquals(stack.getCount(), 0);
    }

    @Test
    public void readTop() {
        MyStack<String> stack = new MyStack<>(3);
        assertTrue(stack.push(test[0]));
        assertSame(stack.peek(), test[0]);

        assertTrue(stack.push(test[1]));
        assertSame(stack.peek(), test[1]);

        assertTrue(stack.push(test[2]));
        assertSame(stack.peek(), test[2]);

        assertFalse(stack.push(test[3]));
        assertSame(stack.peek(), test[2]);
    }

    @Test
    public void isEmpty() {
        // Check empty stack
        MyStack<String> stack1 = this.createStack(new String[]{});
        Assert.assertTrue(stack1.isEmpty());

        // Check stack with one element
        MyStack<String> stack2 = this.createStack(new String[]{""});
        Assert.assertFalse(stack2.isEmpty());

        // Check stack with many elements
        MyStack<String> stack3 = this.createStack(new String[]{"Aa", "Bb"});
        Assert.assertFalse(stack3.isEmpty());
    }

    public MyStack<String> createStack(String[] arr) {
        MyStack<String> stack = new MyStack<>(arr.length);

        for (String string : arr) {
            stack.push(string);
        }

        return stack;
    }
}
package com.cunningbird;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyCharStackTest {

    private final char[] test = { 'a', 'b', 'c', 'd' };

    @Test
    public void push() {
        MyCharStack stack = new MyCharStack(3);
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
        MyCharStack stack = new MyCharStack(3);
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
        MyCharStack stack = new MyCharStack(3);
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
    public void remove() {
        String str = "String";
        char[] strArr = str.toCharArray();

        // Check first element delete
        MyCharStack stack1 = this.createStack(str);
        assertEquals(stack1.remove(0), strArr[0]);

        // Check middle element delete
        MyCharStack stack2 = this.createStack(str);
        assertEquals(stack2.remove(3), strArr[3]);

        // Check last element delete
        MyCharStack stack3 = this.createStack(str);
        assertEquals(stack3.remove(strArr.length - 1), strArr[strArr.length - 1]);
    }

    @Test
    public void isEmpty() {
        // Check empty stack
        MyCharStack stack1 = this.createStack("");
        Assert.assertTrue(stack1.isEmpty());

        // Check stack with one element
        MyCharStack stack2 = this.createStack("S");
        Assert.assertFalse(stack2.isEmpty());

        // Check stack with many elements
        MyCharStack stack3 = this.createStack("Str");
        Assert.assertFalse(stack3.isEmpty());
    }

    public MyCharStack createStack(String str) {
        MyCharStack stack = new MyCharStack(str.length());

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        return stack;
    }
}
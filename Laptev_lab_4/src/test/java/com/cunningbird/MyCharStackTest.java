package com.cunningbird;

import org.junit.Assert;
import org.junit.Test;

public class MyCharStackTest {

    @Test
    public void add() {
        char ch = 's';
        MyCharStack stack = new MyCharStack(1);

        stack.add(ch);

        Assert.assertEquals(ch, stack.readTop());
    }

    @Test
    public void pop() {
        MyCharStack stack = this.createStack("String");

        String strReversed = "gnirtS";
        for (char ch : strReversed.toCharArray()) {
            Assert.assertEquals(ch, stack.pop());
        }
    }

    @Test
    public void readTop() {
        String str = "String";
        char[] strArr = str.toCharArray();
        MyCharStack stack = this.createStack(str);

        Assert.assertEquals(strArr[strArr.length - 1], stack.readTop());
    }

    @Test
    public void remove() {
        String str = "String";
        char[] strArr = str.toCharArray();

        // Check first element delete
        MyCharStack stack1 = this.createStack(str);
        Assert.assertEquals(stack1.remove(0), strArr[0]);

        // Check middle element delete
        MyCharStack stack2 = this.createStack(str);
        Assert.assertEquals(stack2.remove(3), strArr[3]);

        // Check last element delete
        MyCharStack stack3 = this.createStack(str);
        Assert.assertEquals(stack3.remove(strArr.length - 1), strArr[strArr.length - 1]);
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
            stack.add(ch);
        }

        return stack;
    }
}
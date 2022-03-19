package com.brovko.leetcode.easy;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int value = stack.pop();
        if (min.peek() == value) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }


    @Test
    public void test_1() {
        MinStack obj = new MinStack();

        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        assertEquals(-3, obj.getMin());
        obj.pop();
        assertEquals(0, obj.top());
        assertEquals(-2, obj.getMin());
    }

    @Test
    public void test_2() {
        MinStack obj = new MinStack();

        obj.push(-2);
        obj.push(0);
        obj.push(-1);

        assertEquals(-2, obj.getMin());
        assertEquals(-1, obj.top());
        obj.pop();
        assertEquals(-2, obj.getMin());
    }
}


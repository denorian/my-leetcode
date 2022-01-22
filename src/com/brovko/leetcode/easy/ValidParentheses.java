package com.brovko.leetcode.easy;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParentheses {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     *
     * Example 1:
     * Input: s = "()"
     * Output: true
     *
     * Example 2:
     * Input: s = "()[]{}"
     * Output: true
     *
     * Example 3:
     * Input: s = "(]"
     * Output: false
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if ( ! stack.isEmpty() && ((c == ')' && stack.peek() == '(')
                || (c == '}' && stack.peek() == '{')
                || (c == ']' && stack.peek() == '[')))
                stack.pop();
            else
                return false;
        }

        return stack.isEmpty();
    }

    @Test
    public void test_1() {
        assertTrue(isValid("()"));
    }

    @Test
    public void test_2() {
        assertTrue(isValid("()[]{}"));
    }

    @Test
    public void test_3() {
        assertFalse(isValid("(]"));
    }

    @Test
    public void test_4() {
        assertFalse(isValid("([)]"));
    }
}

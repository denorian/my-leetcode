package com.brovko.leetcode.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Sqrt {
    /**
     * Given a non-negative integer x, compute and return the square root of x.
     * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
     * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
     */
    public static int mySqrt(int x) {
        if (x <= 1) return x;

        long res = x;
        while ( ! (res * res <= x && ((res + 1) * (res + 1) > x))) {
            res = res * res > x ? res/10 : res + 1;
        }

        return (int) res;
    }

    @Test
    public void test_1() {
        assertEquals(2, mySqrt(4));
    }
    @Test
    public void test_2() {
        assertEquals(2, mySqrt(8));
    }

    @Test
    public void test_3() {
        assertEquals(46339, mySqrt(2147395599));
    }
}

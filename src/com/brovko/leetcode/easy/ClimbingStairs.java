package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbingStairs {
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    public static int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            b += a;
            a = b - a;
        }
        return a;
    }

    @Test
    public void test_1() {
        assertEquals(2, climbStairs(2));
    }
    @Test
    public void test_2() {
        assertEquals(3, climbStairs(3));
    }


}

package com.brovko.leetcode.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ConcatenationOfArray {

    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }

        return ans;
    }

    @Test
    public void test_1() {
        assertArrayEquals(
            new int[]{1,2,1,1,2,1},
            getConcatenation( new int[]{1,2,1})
        );
    }

    @Test
    public void test_2() {
        assertArrayEquals(
            new int[]{1,3,2,1,1,3,2,1},
            getConcatenation( new int[]{1,3,2,1})
        );
    }
}

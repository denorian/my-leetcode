package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleNumber {

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        return res;
    }

    @Test
    public void test_1() {
        assertEquals(1, singleNumber(new int[]{2,2,1}));
    }

    @Test
    public void test_2() {
        assertEquals(1, singleNumber(new int[]{1}));
    }

    @Test
    public void test_3() {
        assertEquals(4, singleNumber(new int[]{4,1,2,1,2}));
    }

}

package com.brovko.leetcode.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingNumber {
    /**
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number
     * in the range that is missing from the array.
     */
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int sumNums = 0;
        int i = 0;

        for (; i < nums.length; i++) {
            sum += i;
            sumNums += nums[i];
        }

        sum += i;

        return sum - sumNums;
    }

    @Test
    public void test_1() {
        assertEquals(2, missingNumber(new int[]{3,0,1}));
    }

    @Test
    public void test_2() {
        assertEquals(2, missingNumber(new int[]{0,1}));
    }

    @Test
    public void test_3() {
        assertEquals(8, missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}

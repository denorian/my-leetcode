package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumSubarray {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * A subarray is a contiguous part of an array.
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sumFar = Integer.MIN_VALUE;
        int sumEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > sumEnd + nums[i]) {
                sumEnd = nums[i];
            } else {
                sumEnd += nums[i];
            }

            if(sumFar < sumEnd) {
                sumFar = sumEnd;
            }

        }

        return sumFar;
    }

    @Test
    public void test_1() {
        assertEquals(6, maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    @Test
    public void test_2() {
        assertEquals(1, maxSubArray(new int[]{1}));
    }
    @Test
    public void test_3() {
        assertEquals(23, maxSubArray(new int[]{5,4,-1,7,8}));
    }
    @Test
    public void test_4() {
        assertEquals(-1, maxSubArray(new int[]{-1}));
    }
}

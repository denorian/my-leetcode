package com.brovko.leetcode.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BuildArrayFromPermutation {

    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    @Test
    public void test_1() {
        assertArrayEquals(
            new int[]{0,1,2,4,5,3},
            buildArray( new int[]{0,2,1,5,3,4})
        );
    }

    @Test
    public void test_2() {
        assertArrayEquals(
            new int[]{4,5,0,1,2,3},
            buildArray( new int[]{5,0,1,2,3,4})
        );
    }
}

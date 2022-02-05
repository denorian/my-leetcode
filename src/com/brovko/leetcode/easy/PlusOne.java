package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PlusOne {
    /**
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
     * The digits are ordered from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if(carry == 0) return digits;
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;
        }

        if(carry != 0) {
            int[] newRes = new int[digits.length + 1];
            newRes[0] = 1;
            return newRes;
        }

        return digits;
    }


    @Test
    public void test_1() {
        assertArrayEquals(new int[]{1,2,4}, plusOne( new int[]{1,2,3}));
    }

    @Test
    public void test_2() {
        assertArrayEquals(new int[]{4,3,2,2}, plusOne( new int[]{4,3,2,1}));
    }

    @Test
    public void test_3() {
        assertArrayEquals(new int[]{1,0}, plusOne( new int[]{9}));
    }
    @Test
    public void test_4() {
        assertArrayEquals(new int[]{1,0,0,0}, plusOne( new int[]{9,9,9}));
    }
}

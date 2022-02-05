package com.brovko.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddBinary {
    /**
     * Given two binary strings a and b, return their sum as a binary string.
     */
    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if( i >= 0 ) {
                sum = sum + a.charAt(i--) - '0';
            }
            if( j >= 0 ) {
                sum = sum + b.charAt(j--) - '0';
            }

            builder.append(sum % 2);
            carry = sum / 2;
        }

        if(carry != 0) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }

    @Test
    public void test_1() {
        assertEquals("100", addBinary("11", "1"));
    }
    @Test
    public void test_2() {
        assertEquals("10101", addBinary("1010", "1011"));
    }
}

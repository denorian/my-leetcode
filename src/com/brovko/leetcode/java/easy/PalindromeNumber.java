package com.brovko.leetcode.java.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeNumber {
    /**
     * Given an integer x, return true if x is palindrome integer.
     * An integer is a palindrome when it reads the same backward as forward.
     * For example, 121 is a palindrome while 123 is not.
     *
     * Example 1:
     * Input: x = 121
     * Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     *
     * Example 2:
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     *
     * Example 3:
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     *
     * Follow up: Could you solve it without converting the integer to a string?
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int num = x;
        int reverse = 0;
        int lastDigit;

        while (num >= 1) {
            lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            num = num / 10;
        }

        return reverse == x;
    }

    @Test
    public void test_1() {
        assertTrue(PalindromeNumber.isPalindrome(121));
    }
    @Test
    public void test_2() {
        assertFalse(PalindromeNumber.isPalindrome(-121));
    }
    @Test
    public void test_3() {
        assertFalse(PalindromeNumber.isPalindrome(10));
    }
}

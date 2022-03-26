package com.brovko.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstring {

    /**
     * Given a string s, return the longest palindromic substring in s.
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) return "";

        int[] indeces = {0, 0};

        for(int i = 0; i < s.length(); i++) {
            int[] indeces1 = extend(s, i, i);
            if(indeces1[1] - indeces1[0] > indeces[1] - indeces[0]) 
                indeces = indeces1;
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                int[] indeces2 = extend(s, i, i + 1);
                if(indeces2[1] - indeces2[0] > indeces[1] - indeces[0])
                    indeces = indeces2;
            }
        }

        return s.substring(indeces[0], indeces[1] + 1);
    }

    private static int[] extend(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) break;
            i--;
            j++;
        }
        return new int[] {i + 1, j - 1};
    }


    @Test
    public void test_1() {
        assertEquals("bab", longestPalindrome("babad"));
    }

    @Test
    public void test_2() {
        assertEquals("bb", longestPalindrome("cbbd"));
    }
}
